var app = angular.module('app', []);

app.controller('registercontroller', function($scope, $http, $location) {
	$scope.submitRegister = function(){
		var url = $location.absUrl();
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		
		var data = {
            email: $scope.emailreg,
            password: $scope.passwordreg
        };
		
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = "Sucessful!";
		}, function (response) {
			$scope.postResultMessage = "Fail!";
		});
		
		$scope.emailreg = "";
		$scope.passwordreg = "";
		$scope.passwordconf = "";
	}
});