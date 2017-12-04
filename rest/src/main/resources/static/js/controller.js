var app = angular.module('app', []);
 
app.controller('registerController', function($scope, $http, $location) {
	$scope.submitRegForm = function(){
		var url = $location.absUrl();
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		
		var data = {
            email: $scope.email,
            password: $scope.password
        };
		
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = "Sucessful!";
		}, function (response) {
			$scope.postResultMessage = "Fail!";
		});
		
		$scope.email = "";
		$scope.password = "";
	}
});
