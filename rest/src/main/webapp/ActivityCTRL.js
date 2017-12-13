app.controller('activityCtrl', function($scope, $http, $location) {
    $scope.title = "Activities";
    $scope.data = null;

    updateData = function () {
        $http.get("/rest/activity").then(function success(response) {
            $scope.data = response.data;
            console.log($scope.data)
        })
    };
    $scope.remove = function(id) {
        $http.delete("/rest/activity/" + id ).then(function () {
            updateData()
        });
    };
    $scope.generate = function() {
        $http.post("/event").then(function success() {
            $location.path("/myday")
        })

    }
    $scope.getDay = function (day) {
        switch (day) {
            case 0 : return 'Monday';
            case 1 : return 'Tuesday';
            case 2 : return 'Wednesday';
            case 3 : return 'Thursday';
            case 4 : return 'Friday';
            case 5 : return 'Saturday';
            case 6 : return 'Sunday';
        }
    }
    updateData();
});