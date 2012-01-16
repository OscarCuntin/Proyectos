/***************************/
/**** Gallery Functions ****/
/***************************/

var Gallery = function() {

	// Constants
	var ITEMS_PER_PAGE 		= 12;
	var PAGES_RANGE			= 2;
	var TIME_STARTUP_DELAY	= 1;
	var TIME_SEARCH_DELAY 	= 333;
	var GALLERY_URL_DATA 	= root + "_content/" + lang.replace('_','-') + "/" + GALLERY_SUBJECT + ".xml";
	var GALLERY_URL_IMAGE	= akamaiUrl + "_images/community/" + GALLERY_SUBJECT + "/" + galleryLoc + "/";
	var GALLERY_URL_IMAGE_LOC = akamaiUrl + "_images/community/" + GALLERY_SUBJECT + "/" + lang.replace('_','-') + "/";
	var GALLERY_ZOOMIMG_FILEFORMAT 	= '.jpg';
	var GALLERY_THUMBIMG_FILEFORMAT = '-thumb.html';
	var TEXT_CUT = '...';
	var TEXT_CUT_VALUE = 29;

	// State
	var httpParams 		= [];
	var data			= [];
	var filterPackage 	= [];
	var filterType;
	var currentDataView;
	var nPages;
	var searchKeyword;
	var franchiseKeyword;
	var activePageNumber;
	var thumSizeClass 	= "medium";
	var shareSearchFilterNo;
	var searchTimerId;
	var dataFiltered;
	var zoomShots;
	var zoomShotsCaption;
	var zoomShotsDesc;
	var startImageNo;
	//var dataSearchable;
	//var nItems 	= 0;
	//var searchedKeyword;
	//var filterUseOnOff;

	// DOM elements
	var DOM_SEARCH				= $j('#gallery-search');
	var IPT_SEARCH 				= $j('#gallery-search').find('input');
	var DOM_BUTTON_SEARCH_CANCEL= $j('#gallery-search').find('a');
	var DOM_PICTURES			= $j('#gallery-pictures');
	var DOM_TIP					= $j('#gallery-tip');
	var DOM_TOP_PAGES			= $j('#gallery-toppages');
	var DOM_PAGES				= $j('#gallery-pages');
	var DOM_THUMBSIZE			= $j('#gallery-thumbsizes');
	var DOM_FILTER		= [];
	var DOM_DISPLAY_PACKAGE		= [DOM_SEARCH,DOM_PICTURES,DOM_TIP,DOM_TOP_PAGES,DOM_PAGES,DOM_THUMBSIZE];
	var DOM_comicBreadCrumb     = $j("#comicBreadCrumb");
	var DOM_conceptArtBreadCrumb= $j("#conceptArtBreadCrumb");
	var DOM_comicsFlashTitle    = $j("#comicsFlashTitle");
	var DOM_conceptArtFlashTitle= $j("#conceptArtFlashTitle");

	var pictures = [];
	var aPrevPageTop;
	var aNextPageTop;
	var aPrevPage;
	var aNextPage;
	var aPrevEndPage;
	var aNextEndPage;
	var aGoToPage;
	var aThumbSmall;
	var aThumbMedium;
	var aThumbLarge;
	var divPagesInner;

	this.startup = function(){
		setTimeout(fetchData, TIME_STARTUP_DELAY);
	}

	function fetchData(){

		 $j.ajax({//XML data loading...
			 url: GALLERY_URL_DATA,
			 type: "POST",
			 dataType: "xml",
			 success: function(responseXML){receiveData(responseXML);},
			 complete:afterDataFetch
		 });
	}

	function receiveData(responseXML){

		var root = responseXML.documentElement;
		var gallery = $j(root).find('gallery');
		var picData = gallery.find('s');
			if(root.nodeName != GALLERY_DATAROOT || !gallery.length || !picData){
				return;
			}

		var filter = $j(root).find('filter');
			if(filter.length && $j(filter).find('option').length){
				setFilterData(filter);
			}

		setData(picData);
	}

	function afterDataFetch() {

		if(data.length == 0) {
			enterDisabledState(GALLERY_MSG_DATAEMPTY);
		}
	}

	function enterDisabledState(msg) {

		setDisplayPackage(false);
		showMessage(msg, false);
	}

	function setData(submissions) {

		$j.each(submissions, function(i,submission){
			submission = $j(submission);
			if(GALLERY_MSG_ANONYMOUS){
				var artistName = (submission.attr('name')!='')?submission.attr('name'):GALLERY_MSG_ANONYMOUS;
				if(artistName.length > TEXT_CUT_VALUE){
					artistName = artistName.substr(0,TEXT_CUT_VALUE) + TEXT_CUT;
				} else {artistName;}

			} else if(!GALLERY_MSG_ANONYMOUS){
				var artistName = null;
			}

			data.push({
				id:    submission.attr('imgId'),
				name:  artistName,
				title: submission.attr('title'),
				date:  submission.attr('date'),
				desc:  (submission.text())?submission.text() : null,
				ip: (submission.attr('ip'))?submission.attr('ip'): null
			});
		}); data.reverse();

		//dataFiltered = false;
		//dataSearchable = false;
		currentDataView = data;
		updatePageCount();
		initialize();
	}

	function setFilterData(filter) {

		$j.each(filter, function(i,filterItem){
			var filterOptions = [];
			$j.each($j(filterItem).find('option'),function(i,option){
				filterOptions.push({
					key: $j(option).attr('key'),
					label: $j(option).attr('label')
				});
			});
			filterPackage.push({
				type: $j(filterItem).attr('type'),
				options: filterOptions,
				filterkey: $j(filterItem).attr('filterkey')
			});
		});
	}

	function initialize() { //TO DO: clean

		getParameter();
		initFilter();
		initSearch();
		initPictures();
		initTopPages();
		initPages();
		initThumbSize();
		initKeyboard();
		initViewScreenshot();
		refresh();
	}

	function initSearch() {

		DOM_BUTTON_SEARCH_CANCEL.click(function(){cancelSearch();});
		IPT_SEARCH.attr('value', GALLERY_INIT_SEARCH);
		IPT_SEARCH.keyup(function(){searchOnKeyUp()});
		IPT_SEARCH.focus(function(){searchOnFocus(this)});
		IPT_SEARCH.blur(function(){searchOnBlur(this)});
	}

	function searchOnKeyUp() {
		var ipt_txt = IPT_SEARCH.attr('value');

		if(shareSearchFilterNo){
			if(ipt_txt != DOM_FILTER[shareSearchFilterNo].param.text().toLowerCase() && DOM_FILTER[shareSearchFilterNo].param.text() != DOM_FILTER[shareSearchFilterNo].basictext){
				DOM_FILTER[shareSearchFilterNo].param.text(DOM_FILTER[shareSearchFilterNo].basictext);
			}
			$j.each(filterPackage[shareSearchFilterNo].options, function(i,option){
				if(option.key.toLowerCase() == ipt_txt.toLowerCase()){
					DOM_FILTER[shareSearchFilterNo].param.text(option.key);
				}
			});
		};
		setBeforeDoSearch($j.trim(ipt_txt));
	}

	function setBeforeDoSearch(keyword){



		if(franchiseKeyword){
			cancelFilter(0);
		}

		if(!keyword){
			var keyword = searchKeyword;
		}

		searchKeyword = keyword.toLowerCase();

		if(searchTimerId)
		{
			clearTimeout(searchTimerId);
			searchTimerId = null;
		}

		if(keyword == GALLERY_INIT_SEARCH || keyword == ''){
			keyword = null;
		}

		if(shareSearchFilterNo){
			if(keyword == DOM_FILTER[shareSearchFilterNo].basictext){
				keyword = null;
			}
		}

		if(!keyword && dataFiltered){
			setValueCancelSearch();
			updatePageCount();
			refresh();
			return;
		}

		if(searchKeyword == DOM_SEARCH.data('lastSearchkeyword')){
			return;
		}

		DOM_SEARCH.data('lastSearchkeyword',searchKeyword);
		dataFiltered 	= true;
		currentDataView = [];

		searchTimerId 	= setTimeout(doSearch, TIME_SEARCH_DELAY);
	}

	function setBeforeDoFilter(selectedFilterNo){

		if(searchTimerId)
		{
			clearTimeout(searchTimerId);
			searchTimerId = null;
		}

		currentDataView = [];

		if(filterPackage[selectedFilterNo].filterkey == 'name'){
			filterType = 'name';
			IPT_SEARCH.attr('value',searchKeyword);
			searchKeyword = searchKeyword.toLowerCase();
			searchTimerId 	= setTimeout(doSearch, TIME_SEARCH_DELAY);
		}else {
			filterType = 'ip';
			franchiseKeyword = franchiseKeyword.toLowerCase();
			searchTimerId 	= setTimeout(doFranchiseSearch, TIME_SEARCH_DELAY);
		}

	}

	function doFranchiseSearch(){

		$j.each(data, function(i, submission){
			var keyword =  franchiseKeyword.toLowerCase();
			if(submission.ip){
				if(submission.ip.toLowerCase().indexOf(keyword) != -1){
					currentDataView.push(submission);
				}
			}
		});

		setAfterDoSearch('franchise');
	}

	function doSearch(){

		$j.each(data, function(i, submission){
			var keyword =  searchKeyword.toLowerCase();
			if(submission.name){
				if(submission.name.toLowerCase().indexOf(keyword) != -1){
					currentDataView.push(submission);
				}
			}
		});

		setAfterDoSearch();
	}

	function setAfterDoSearch(type){

		if(type != 'franchise'){
			DOM_BUTTON_SEARCH_CANCEL.show();
		} else {
			if(searchKeyword){
				cancelSearch();
			}
		}

		if(currentDataView.length > 0) {
			setDisplayPackage(true);
			updatePageCount();
			refresh();

		} else {
			setDisplayPackage(false);
			DOM_SEARCH.show();
			showMessage(GALLERY_MSG_NOMATCHES, true);
		}
		searchTimerId = null;
		setHideFilterOnClick();
	}


	function searchOnFocus(ipt) {
		if(ipt.value == GALLERY_INIT_SEARCH) {
			ipt.value = '';
			DOM_SEARCH.addClass('activated');
		}
	}

	function searchOnBlur(ipt){
		if(!$j.trim(ipt.value).length) {
			setTimeout(setBackSearch, TIME_SEARCH_DELAY);
		}
	}

	function setBackSearch(){
		if(shareSearchFilterNo){
			DOM_FILTER[shareSearchFilterNo].param.text(DOM_FILTER[shareSearchFilterNo].basictext);
		}
		IPT_SEARCH.attr('value', GALLERY_INIT_SEARCH);
		DOM_SEARCH.removeClass('activated');
		DOM_BUTTON_SEARCH_CANCEL.hide();
	}


	function cancelSearch(){

		if(!searchKeyword){return;}
		setBackSearch();
		setValueCancelSearch();
		setHideFilterOnClick();
		updatePageCount();
		refresh();
	}

	function setValueCancelSearch(){

		searchKeyword   = null;
		dataFiltered = false;
		if(!franchiseKeyword){currentDataView = data;}
		clearTimeout(searchTimerId);
		searchTimerId = null;
		setDisplayPackage(true);
	}

	function setHideFilterOnClick() {
		$j('#filter-franchises').find('#sort_opt').hide();
		$j('#filter-artists').find('#sort_opt').hide();
	}

	function initFilter() {

		$j.each(filterPackage,function(i,filterItem){
			var typeName = (filterItem.type != 'artists')?GALLERY_INIT_FILTER_FRANCHISE:GALLERY_INIT_FILTER_ARTIST;
			var fixingWidth = eval(FILTER_FIXING_WIDTH);
			DOM_FILTER.push({// DOM elements package
				root: $j('#filter-'+ filterItem.type),
				param: $j('#filter-'+ filterItem.type + ' .filterparam'),
				options: $j('#filter-'+ filterItem.type + ' .options'),
				basictext: typeName
			});
			DOM_FILTER[i].root.show();
			$j(DOM_FILTER[i].root).find('.filterbox').click(function(){
				$j(DOM_FILTER[i].root).find('#sort_opt').slideToggle("fast");
			});
			DOM_FILTER[i].param.text(DOM_FILTER[i].basictext);
			DOM_FILTER[i].options.append($j('<a>').text(DOM_FILTER[i].basictext).click(function(){
				cancelFilter(i);
			}));
			$j.each(filterItem.options, function(j,option){
			    DOM_FILTER[i].options.append($j('<a>').text(option.label).attr('key',option.key).click(function(){
			        searchOnFilter($j(this),i);
			    }));
			});

			fixingWidth = Math.max(DOM_FILTER[i].root.width(),fixingWidth);
			$j(DOM_FILTER[i].root).find('.center').css('width',fixingWidth-16+'px');
			$j(DOM_FILTER[i].root).css('width',fixingWidth+'px');
			if(filterItem.filterkey == 'name'){shareSearchFilterNo = i;}
		});
	}

	function toggleComicTitle(showComicTitle) {

	    if (showComicTitle) {
	        document.title = GALLERY_MSG_COMIC_TITLE;

            DOM_conceptArtBreadCrumb.fadeOut(100, function() {
                DOM_comicBreadCrumb.fadeIn(100)
            });

            DOM_conceptArtFlashTitle.fadeOut(100, function() {
                DOM_comicsFlashTitle.fadeIn(100)
            });
	    } else {
	        document.title = GALLERY_MSG_ART_TITLE;

            DOM_comicBreadCrumb.fadeOut(100, function() {
                DOM_conceptArtBreadCrumb.fadeIn(100)
            });

            DOM_comicsFlashTitle.fadeOut(100, function() {
                DOM_conceptArtFlashTitle.fadeIn(100)
            });
	    }
	}

	function searchOnFilter(selectedObj,selectedFilterNo){

		DOM_FILTER[selectedFilterNo].param.text(selectedObj.text());
		if(filterPackage[selectedFilterNo].filterkey == 'ip'){
			franchiseKeyword = selectedObj.attr('key');

			toggleComicTitle(franchiseKeyword == "comics")

			cancelSearch();
		} else {
			if(franchiseKeyword){
				cancelFilter(0);
			}
			searchKeyword = selectedObj.attr('key');


		}
		setBeforeDoFilter(selectedFilterNo);
	}

	function cancelFilter(selectedFilterNo){


	    toggleComicTitle(false)

		DOM_FILTER[selectedFilterNo].param.text(DOM_FILTER[selectedFilterNo].basictext);

		if(filterPackage[selectedFilterNo].filterkey == 'ip'){
			if(!franchiseKeyword){
				return;
			}
			franchiseKeyword = null;
		}
		if(!franchiseKeyword){
			currentDataView = data;
		}
		setAfterDoSearch('franchise');

	}


	function updatePageCount() {
		nPages = getPageNumber(currentDataView.length - 1);
		activePageNumber = 1;
	}

	function getPageNumber(submissionNo) {
		return Math.ceil((submissionNo + 1) / ITEMS_PER_PAGE);
	}

	function getParameter(){

		if(window.location.search) {

			var params = window.location.search.substring(1).split("&");
			for(var x in params){
				p = params[x].split("=");
				httpParams[p[0]] = p[1].replace(/%20/gi,' ');
			}
			if(httpParams['search']){
				searchKeyword = httpParams['search'];
			}
			if(httpParams['ip']){
				franchiseKeyword = httpParams['ip'];
			}
		}

		if(window.location.hash){
			startImageNo = window.location.hash.substring(1);
		}
	}

	function initKeyboard() {

		if($j.browser.msie || $j.browser.safari ){
			$j(document).keydown(function(event){ onKeyPress(event); });

		} else {
			$j(document).keypress(function(event){ onKeyPress(event); });
		}
	}

	function initViewScreenshot(){

		if(franchiseKeyword){
			$j.each(filterPackage[0].options, function(i,filterOption){
				if(franchiseKeyword == filterOption.key.toLowerCase()){
					DOM_FILTER[0].param.text(filterOption.label);
				}
			});
			setBeforeDoFilter(0);
		}
		if(searchKeyword){
			if(shareSearchFilterNo != null){
				$j.each(filterPackage[shareSearchFilterNo].options, function(i,filterOption){
					if(searchKeyword == filterOption.key.toLowerCase()){
						DOM_FILTER[shareSearchFilterNo].param.text(filterOption.label);
					}
				});
			};
			IPT_SEARCH.attr('value',DOM_FILTER[shareSearchFilterNo].param.text());
			setBeforeDoSearch(searchKeyword);
		}
		if(startImageNo){setTimeout(loadStartImage, TIME_SEARCH_DELAY);}
	}

	function loadStartImage(){
		getActivePageNumber(startImageNo);
		currentZoomshot = startImageNo;
		omegaLightBox();
	}

	function getActivePageNumber(submissionNo){
		activePageNumber = parseInt((currentDataView.length - 1 - submissionNo) / ITEMS_PER_PAGE) + 1;
	}

	function onKeyPress(event){

		var lightboxVisible = !!($j('#blackout') && $j('#blackout').css('display') == 'block');

		switch (event.keyCode) {

			case 37: // Left
				if(lightboxVisible) {
					getActivePageNumber(sV.prevImage());
					refresh();

				} else {
					prevPage();
				}
				break;

			case 39: // Right
				if(lightboxVisible) {
					getActivePageNumber(sV.nextImage());
					refresh();
				} else {
					nextPage();
				}
				break;
		}
	}


	function showMessage(msg, isError) {

		var divMessage = $j('#gallery-message').empty();

		if(msg) {
			if(isError) {
				divMessage.append($j('<div>').addClass('error')
						.append($j('<big>').text(GALLERY_MSG_ERROR))
						.append($j('<p>').text(msg)));
			} else {
				divMessage.append($j('<p>').text(msg))
			}
		}
	}


	function refresh() {

		refreshPictures();
		refreshPages();
		setDataZoomShot();
		showMessage(null);
	}

	function setDataZoomShot(){

		zoomShots = []; zoomShotsCaption = []; zoomShotsDesc = [];

		for(var i = 0; i < currentDataView.length; i++)
		{
		    if (currentDataView[i].ip == "comics") {
		        zoomShots[currentDataView.length - 1 - i] = getImgZoomUrlLoc(currentDataView[i].id);
		    } else {
		        zoomShots[currentDataView.length - 1 - i] = getImgZoomUrl(currentDataView[i].id);
		    }

			zoomShotsCaption[currentDataView.length - 1 - i] = getImgZoomCaption(currentDataView[i]);
			zoomShotsDesc[currentDataView.length - 1 - i] = currentDataView[i].desc;
		}
	}

	function refreshPictures() {
		var aCurrentshowNum = DOM_PICTURES.children('div').length;
		var nSubmissionsToSkip = (activePageNumber - 1) * ITEMS_PER_PAGE;
		var nVisibleItems = currentDataView.length;
		var pictureNo = 0;
		var submissionNo = 0 + nSubmissionsToSkip;

		while(pictureNo < ITEMS_PER_PAGE && submissionNo < nVisibleItems) {
			setPicture(pictureNo, submissionNo);
			++submissionNo;
			++pictureNo;
		}
		while(pictureNo < ITEMS_PER_PAGE) {
			setPicture(pictureNo, null);
			++pictureNo;
		}
		// Change display of no showing pictures : to select thumb size
		while((aCurrentshowNum - pictureNo) > 0) {
			setPicture((aCurrentshowNum-1), null);
			aCurrentshowNum--;
		}
	}

	function initPictures() {

		for(var i = 0; i < ITEMS_PER_PAGE; ++i) {

			DOM_PICTURES.append(createPicture());
		}

		DOM_PICTURES.addClass('pictures').addClass(thumSizeClass);

		// Overwrite the lightbox's behavior when clicked
		var lightbox = $j('#lightBoxRoot')[0];
		if(lightbox) {
			lightbox.onclick = nextSubmission;
			$j('#lightBoxHolder')[0].title = '';
		}
	}

	function createPicture() {

		// <div class="picture"><a href="#"></a><span></span></div>
		var div = $j('<div>')
				.addClass('picture')
				.css('display','none');

		var a = $j('<a>').attr('href','Javascript:;')
				.append($j('<span>'))
				.append($j('<div>'));

		var span = $j('<span>').addClass('name');

		div.append(a).append(span);

		var picture = {
			div:  div,
			a:    a,
			span: span
		};

		pictures.push(picture);
		return div;
	}

	function setPicture(pictureNo, submissionNo) {

		var picture    = pictures[pictureNo];
		var submission = currentDataView[submissionNo];

		if(!submission) {
			picture.div.hide();
			return;
		}

		picture.a.data('currentViewNo', currentDataView.length - 1 - submissionNo);

		picture.a.unbind('click');
		picture.a.bind('click', function(){
			currentZoomshot = $j(this).data('currentViewNo');
			omegaLightBox();
		});



		pictureImage = new Image();

		if (submission.ip == "comics") {
		    pictureImage.src = getImgThumbUrlLoc(submission.id);
		} else {
		    pictureImage.src = getImgThumbUrl(submission.id);
		}


		picture.a.children('span').empty().append(pictureImage);
		if(submission.name){
			picture.span.text(submission.name);
		}
		picture.div.show();


	}

	function initTopPages() {

		var links     = DOM_TOP_PAGES.children('a');
		aPrevPageTop     = links[0];
		aNextPageTop     = links[1];
		aPrevPageTop.onclick = prevPage;
		aNextPageTop.onclick = nextPage;
	}

	function setPage(newPageNumber) {

		if(!newPageNumber || isNaN(newPageNumber) || newPageNumber < 1 || newPageNumber > nPages || newPageNumber == activePageNumber)
			return;

		activePageNumber = newPageNumber;
		refresh();
	}

	function prevPage() {
		(activePageNumber == 1)?setPage(nPages):setPage(activePageNumber - 1);
		return false;
	}

	function nextPage() {
		(activePageNumber == nPages)?setPage(1):setPage(activePageNumber + 1);
		return false;
	}

	function prevEndPage() {
		setPage(1);
		return false;
	}

	function nextEndPage() {
		setPage(nPages);
		return false;
	}

	function initPages() {

		var links     = DOM_PAGES.children('div').children('a');
		aPrevEndPage  = links[0];
		aPrevPage     = links[1];
		aNextPage     = links[2];
		aNextEndPage  = links[3];
		aGoToPage     = DOM_PAGES.children('a')[0];
		divPagesInner = DOM_PAGES.children('div').children('div');
		aPrevPage.onclick    = prevPage;
		aNextPage.onclick    = nextPage;
		aPrevEndPage.onclick = prevEndPage;
		aNextEndPage.onclick = nextEndPage;
		aGoToPage.onclick = goToPage;
	}

	function goToPage() {

		var msg = GALLERY_MSG_GOTOPAGE.replace('$MAX', nPages);

		var num = parseInt(prompt(msg, activePageNumber));
		if(!num || isNaN(num)) {
			return;
		}

		setPage(num);
		return false;
	}

	function initThumbSize() {

		var links     = DOM_THUMBSIZE.children('a');
		aThumbSmall   = links[0];
		aThumbMedium  = links[1];
		aThumbLarge   = links[2];
		aThumbSmall.onclick  = toggleThumbSize;
		aThumbMedium.onclick = toggleThumbSize;
		aThumbLarge.onclick  = toggleThumbSize;
		$j(aThumbMedium).addClass('selected');
	}

	function toggleThumbSize() {

		var targetSize = this.id.substring(6);
		var links     = DOM_THUMBSIZE.children('a');

		if (thumSizeClass != targetSize) {
			DOM_PICTURES.removeClass(thumSizeClass);
			thumSizeClass = targetSize;
			(targetSize.toLowerCase()=='small')?ITEMS_PER_PAGE = 20:(targetSize.toLowerCase()=='medium')?ITEMS_PER_PAGE = 12:ITEMS_PER_PAGE = 6;

			for(var i = 0; i < links.length; i++){

				links.eq(i).removeClass().addClass(links[i] != this? '' :'selected');
			}

			updatePageCount();
			initPictures();
			initPages();
			refresh();

		} else {
			return;
		}
	}

	function getImgZoomUrl(submission) {
		return GALLERY_URL_IMAGE + submission + GALLERY_ZOOMIMG_FILEFORMAT;
	}

	function getImgZoomUrlLoc(submission) {
        return GALLERY_URL_IMAGE_LOC + submission + GALLERY_ZOOMIMG_FILEFORMAT;
    }

	function getImgThumbUrl(submission) {
		return GALLERY_URL_IMAGE + submission + GALLERY_THUMBIMG_FILEFORMAT;
	}

	function getImgThumbUrlLoc(submission) {
        return GALLERY_URL_IMAGE_LOC + submission + GALLERY_THUMBIMG_FILEFORMAT;
    }

	function getImgZoomCaption(submission) {
		var ImgZoomCaption = submission.title + ' - ';
		if(submission.name){
			ImgZoomCaption += submission.name + ' - ';
		}
			ImgZoomCaption += submission.date;

		return ImgZoomCaption;
	}

	function refreshPages() {

		var minPageNumber = Math.max(activePageNumber - PAGES_RANGE, 1);
		var maxPageNumber = Math.min(activePageNumber + PAGES_RANGE, nPages);
		aPrevPage.className = aPrevEndPage.className = (activePageNumber == 1? 'disabled' : '');
		aNextPage.className = aNextEndPage.className = (activePageNumber == nPages? 'disabled' : '');
		aPrevPageTop.className = aNextPageTop.className =  (nPages == 1? 'nodisplay' : '');
		aGoToPage.className    = (nPages == 1? 'disabled' : '');
		divPagesInner.empty();

		if(1 < minPageNumber) {

			divPagesInner.append(createPageButton(1));

			if(1 < minPageNumber - 1) {
				divPagesInner.append($j('<span>').text('...'));
			}
		}

		for(var i = minPageNumber; i <= maxPageNumber; ++i){

			divPagesInner.append(createPageButton(i));

		}

		if(nPages > maxPageNumber) {

			if(nPages > maxPageNumber + 1) {
				divPagesInner.append($j('<span>').text('...'));
			}

			divPagesInner.append(createPageButton(nPages));
		}
	}

	function createPageButton(pageNumber) {

		var a = $j('<a>').text(pageNumber);
			a[0].href = 'javascript:;';
			a[0].onclick = pageButtonOnClick;

		if(pageNumber == activePageNumber) {
			a.addClass('selected');
		}
		return a;
	}

	function pageButtonOnClick(){
		setPage(parseInt($j(this).text()));
		return false;
	}

	function setDisplayPackage(option){

		$j.each(DOM_DISPLAY_PACKAGE, function(i,dom){
			if(option)dom.show();
			else dom.hide();
		});
	}

	function omegaLightBox() {
		artgalleryhash = true;
		setHideFilterOnClick();
		sV.setImageCollection(zoomShots,currentZoomshot,zoomShotsCaption,searchKeyword,zoomShotsDesc,franchiseKeyword,true);
		startImageNo = null;
	}

	function setFlashVar(varName, varValue){
	     flashMovie.setVariable(varName, varValue);
	}
};