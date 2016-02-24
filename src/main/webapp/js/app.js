var app = angular.module('myGraphApp',['ui.router','ui.bootstrap']);

app.constant('appProperties',{
	urls:{
		listOfPersons:'rest/persons',
		getPerson:'rest/persons/',
		getRelationshipsForPerson:'rest/persons/relationship/',
		getRelationshipTypeMap:'ajax/relationsMap.json'
	}
})

app.config(['$stateProvider', '$urlRouterProvider',function($stateProvider, $urlRouterProvider) {
	//
	// For any unmatched url, redirect to /state1
	$urlRouterProvider.otherwise("/home");
	//
	// Now set up the states
	$stateProvider
		.state('state1', {
			url: "/home",
			//resolve: { title: 'My Contacts' },
			params:{personId:""},
			onEnter: ['$stateParams',function($stateParams){
				console.log("On enter "+$stateParams.personId);
			}],
			onExit: ['$stateParams',function($stateParams){
				console.log("On exit "+$stateParams.personId);
			}],
			views: {
				"viewLeft": {
					template: '<person-table person-id="{{personId}}"></person-table>',
					controller: ['$scope', '$stateParams', function($scope, $stateParams) {
						console.log($stateParams);

						$scope.personId = $stateParams.personId;
						console.log('Ctrl:'+$stateParams.personId);
					}]},
				"viewMain": {
					templateUrl: "partials/state1.html",
					controller: ['$scope', '$stateParams','PersonService', function($scope, $stateParams, PersonService) {
						$scope.search = "";
						$scope.showAll = false;
						$scope.query = {name:$scope.search};
						PersonService.getListOfPersons(function(data, status, headers, config) {
							//$scope.data = data;
							$scope.persons = data;
						},function(data, status, headers, config) {
							alert("AJAX failed!");
						});

						/*
						$scope.frameworks = [
							{name: 'Django', language: 'Python'},
							{name: 'AngularJS', language: 'Javascritp'}
						];
						*/

					}]
				}
			}

		})

		.state('relationshipState', {
			url: '/relationship/:personId',
			onEnter: ['$stateParams',function($stateParams){
				console.log("On enter sub state "+$stateParams.personId);
			}],
			onExit: ['$stateParams',function($stateParams){
				console.log("On exit sub state "+$stateParams.personId);
				$stateParams.personId = "";
			}],
			views: {
				"viewLeft": {
					template: '<person-table person-id="{{personId}}"></person-table>',
					controller: ['$scope', '$stateParams', function($scope, $stateParams) {
						console.log($stateParams);

						$scope.personId = $stateParams.personId;
						console.log('Ctrl:'+$stateParams.personId);
					}]},
				"viewMain": {
					template: '<graph-chart person-id="{{personId}}"></graph-chart>',
					controller: ['$scope', '$stateParams', function($scope, $stateParams) {
						$scope.personId = $stateParams.personId;
					}]
				}
			}
		})
		.state('personDetail', {
			url: '/personDetail/:personId',
			views: {
				"viewLeft": { template: "X" },
				"viewMain": {
					template: 'Yeaah person {{personId}}',
					controller: ['$scope', '$stateParams', function($scope, $stateParams) {
						$scope.personId = $stateParams.personId;
					}],
				}
			}

		});
}]);




app.controller('GraphController', ['$scope', function($scope) {
	$scope.getRandom = function(){
		return Math.floor((Math.random()*6)+1);
	}
	$scope.id = 'graph-' +$scope.getRandom();
   
  }]);