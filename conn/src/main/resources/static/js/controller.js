var app = angular.module('app', []);

app.controller('registercontroller', function($scope, $http, $location) {
	$scope.submitRegister = function(){
		var url = $location.absUrl();
		
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
            email: $scope.emailreg,
            password: $scope.passwordreg,
            //passwordconf: $scope.passwordconf
        };
		
		$http.post(url, data, config).then(function (response) {
			console.log(response.data);
		}, function error(response) {
			console.log(response.statusText);
		});
		
		$scope.emailreg = "";
		$scope.passwordreg = "";
		//$scope.passwordconf = "";
	}
});