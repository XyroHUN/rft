app.controller('activityCtrl', function($scope) {
$scope.title = "Activities";
var data = [
    {"id": 1,
    "action" : "megirni",
    "interval" : "3 óra",
    "days" : ["hétfő"]
    },    
    {"id": 2,
    "action" : "futás",
    "interval" : "2 óra",
    "days" : ["hétfő","kedd","szerda"]
    },
    {
        "id" : 3,
        "action" : "suli",
        "interval" : "4 óra 30 perc",
        "days" : ["kedd", "szerda"]
    }
]
$scope.getData = function() {
    return data;
}
$scope.remove = function(activity) {
    data = data.filter(function (act) {
        return act.id !== activity.id});
}
});