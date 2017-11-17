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

app.controller('logincontroller', function($scope, $http, $location) {
	
	$scope.submitLogin = function() {
		var url = $location.absUrl() + "login";

		var config = {
			headers : {	'Content-Type' : 'application/json;charset=utf-8;' },
		
			params: { 'email' : $scope.email, 'password' : $scope.password }
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.postResultMessage = response.data;

			} else if(response.data.status == "Fail") {
				$scope.postResultMessage = "Customer Data Error!";
			}

		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

	}
});