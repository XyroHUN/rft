app.controller('activityCtrl', function($scope, $http) {
    $scope.title = "Activities";
    $scope.data = null;

    updateData = function () {
        $http.get("/rest/activity").then(function success(response) {
            $scope.data = response.data;
        })
    };
    $scope.remove = function(id) {
        $http.delete("/rest/activity/" + id ).then(function () {
            updateData()
        });
    };
    updateData();
});