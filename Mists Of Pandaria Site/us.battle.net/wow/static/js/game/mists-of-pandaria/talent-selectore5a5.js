$(function() {
	TalentSelector.initialize();
});

var TalentSelector = {
	calc: null,
	tabs: null,
	cache: {},
	instances: {},

	initialize: function() {
		TalentSelector.tabs = $('#selector a');
		TalentSelector.tabs.click(function(e) {
			e.preventDefault();
			e.stopPropagation();

			TalentSelector.view( $(e.currentTarget).data('id'), true );
		});

		TalentSelector.calc = $('#calculators');

		var hash = Core.getHash();

		if (hash && hash != '.') {
			var id = Hash.decode(hash.substr(0, 1));

			if (id[0] && id[0] > 0 && id[0] < 12)
				TalentSelector.view(id[0], false);
		}
	},

	view: function(id, reset) {
		if (!id) {
			return false;
		}

		$('#selector').addClass('picked');

		TalentSelector.tabs.removeClass('tab-selected');
		$('#class-' + id).addClass('tab-selected');

		if (TalentSelector.cache[id]) {
			TalentSelector.calc.find('.talent-calculator').hide();
			TalentSelector.cache[id].show();
			TalentSelector.instances[id].exportBuild();

			return false;
		}

		TalentSelector.load(id, reset);

		return false;
	},

	load: function(id, reset) {
		if (reset)
			location.replace('#.');

		$.ajax({
			url: Core.baseUrl + '/game/mists-of-pandaria/feature/talent-calculator.frag?class=' + id,
			type: 'GET',
			dataType: 'html',
			success: function(response) {
				TalentSelector.calc.find('.talent-calculator').hide();
				TalentSelector.cache[id] = $(response).appendTo(TalentSelector.calc);
				TalentSelector.instances[id].exportBuild();

				$('#choose-class').hide();
			}
		});
	}
};