app.controller('addActivityCtrl', function($scope, $http, $location) {
    $scope.activityName = '';
    $scope.activityNameError = '';

    $scope.weekDays = {
        'Hétfő': {
            'opened':false,
            'fromError':'',
            'toError':'',
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0)
        },
        'Kedd': {
            'opened':false,
            'fromError':'',
            'toError':'',
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0)},
        'Szerda': {
            'opened':false,
            'fromError':'',
            'toError':'',
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0)},
        'Csütörtök': {
            'opened':false,
            'fromError':'',
            'toError':'',
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0)},
        'Péntek': {
            'opened':false,
            'fromError':'',
            'toError':'',
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0)},
        'Szombat': {
            'opened':false,
            'fromError':'',
            'toError':'',
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0)},
        'Vasárnap': {
            'opened':false,
            'fromError':'',
            'toError':'',
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0)}
    }

    $scope.week = {
        'week' : {
            'minAlkalomError' :'',
            'maxAlkalomError' :'',
            'minAlkalom':0,
            'maxAlkalom':0,
            'minOraError':'',
            'maxOraError':'',
            'minOra':0,
            'maxOra':0
        }
    };

    var valid;
    $scope.submit = function () {
        clearErrors();
        valid = true;
        validateActivity();
        if (valid) {
            var thedays = []
            for (day in $scope.weekDays) {
                if ($scope.weekDays[day].opened) {
                    var hours = []
                    for (n = $scope.weekDays[day].from.getHours();n<$scope.weekDays[day].to.getHours();n++) {
                        hours.push(n);
                    }
                    var dayobj = {
                        'day' : day,
                        'hours' : hours
                    }
                thedays.push(dayobj);
                }
            }
            var content = {
                'name' : $scope.activityName,
                'time' : thedays,
                'rules' : [$scope.week.minAlkalom, $scope.week.maxAlkalom, $scope.week.minOra, $scope.week.maxOra]
            };
            $http.post('http://localhost:8080/rest/activity',content).then(function () {
                $location.path("/activity");
            });
        }
    }
    validateDay = function(day) {
        if (day.from >= day.to) {
            day.fromError = 'is-invalid';
            valid = false;
        }
    };
    validateWeek = function(week) {
        if (week.minAlkalom>week.maxAlkalom) {
            week.minAlkalomError = 'is-invalid';
            valid = false;
        }
        if (week.minOra>week.maxOra) {
            week.minOraError ='is-invalid';
            valid = false;
        }
    };
    validateActivity = function () {
        if ($scope.activityName === '') {
            valid = false
            $scope.activityNameError='is-invalid'            
        }
        
        for (day in $scope.weekDays) {
            if ($scope.weekDays[day].opened) {
                validateDay($scope.weekDays[day])
            }
        }
        validateWeek($scope.week);
    };
    clearErrors = function() {
        
        for (day in $scope.weekDays) { 
            day.fromError = '';
            day.minError ='';
            day.maxError = '';
        }
        $scope.week.minAlkalomError = '';
        $scope.week.minOraError ='';
        $scope.activityNameError=''    
    }
});