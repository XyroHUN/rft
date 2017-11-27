app.controller('addActivityCtrl', function($scope) {
    $scope.classes = {
        'monday': {
            'from': '',
            'to': '',
            'min': '',
            'max': ''
        },
        'tuesday': {
            'from': '',
            'to': '',
            'min': '',
            'max': ''
        },
        'wednesday': {
            'from': '',
            'to': '',
            'min': '',
            'max': ''
        },
        'thursday': {
            'from': '',
            'to': '',
            'min': '',
            'max': ''
        },
        'friday': {
            'from': '',
            'to': '',
            'min': '',
            'max': ''
        },
        'saturday': {
            'from': '',
            'to': '',
            'min': '',
            'max': ''
        },
        'sunday': {
            'from': '',
            'to': '',
            'min': '',
            'max': ''
        },
    };

    $scope.activity = {
        'monday': {
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0),
            'min': new Date(0,0,0,0,0,0,0),
            'max': new Date(0,0,0,0,0,0,0)
        },
        'tuesday': {
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0),
            'min': new Date(0,0,0,0,0,0,0),
            'max': new Date(0,0,0,0,0,0,0)
        },
        'wednesday': {
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0),
            'min': new Date(0,0,0,0,0,0,0),
            'max': new Date(0,0,0,0,0,0,0)
        },
        'thursday': {
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0),
            'min': new Date(0,0,0,0,0,0,0),
            'max': new Date(0,0,0,0,0,0,0)
        },
        'friday': {
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0),
            'min': new Date(0,0,0,0,0,0,0),
            'max': new Date(0,0,0,0,0,0,0)
        },
        'saturday': {
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0),
            'min': new Date(0,0,0,0,0,0,0),
            'max': new Date(0,0,0,0,0,0,0)
        },
        'sunday': {
            'from': new Date(0,0,0,0,0,0,0),
            'to': new Date(0,0,0,0,0,0,0),
            'min': new Date(0,0,0,0,0,0,0),
            'max': new Date(0,0,0,0,0,0,0)
        },
    }

    $scope.class = {
        'week' : {
            'min' :'',
            'max' :''
        }
    }
    $scope.activit = {
        
        'week' : {
            'min':0,
            'max':0
        }
    }

    $scope.submit = function () {
        validateActivity();
    }
    validateDay = function(day, klass) {
        if (day.from > day.to) {
            klass.from = 'is-invalid';
        }
        if (day.min > day.max) {
            klass.min ='is-invalid';
        }
        if (day.max.getHours() > day.to.getHours()-day.from.getHours() ||
         (day.max.getHours() == day.to.getHours()-day.from.getHours() &&
          day.max.getMinutes() > day.to.getMinutes()-day.from.getMinutes() ) ) {
            klass.max = 'is-invalid';
        } 

    }
    validateWeek = function(week, klass, days) {
        if (week.min>week.max) {
            klass.min = 'is-invalid';
        }
    }
    validateActivity = function () {
        var monday = $scope.activity.monday;
        var tuesday = $scope.activity.tuesday;
        var wednesday = $scope.activity.wednesday;
        var thursday = $scope.activity.thursday;
        var friday = $scope.activity.friday;
        var saturday = $scope.activity.saturday;
        var sunday = $scope.activity.sunday;
        validateDay(monday, $scope.classes.monday);
        validateDay(tuesday, $scope.classes.tuesday);
        validateDay(wednesday, $scope.classes.wednesday);
        validateDay(thursday, $scope.classes.thursday);
        validateDay(friday, $scope.classes.friday);
        validateDay(saturday, $scope.classes.saturday);
        validateDay(sunday, $scope.classes.sunday);
        validateWeek($scope.activit.week, $scope.class.week, $scope.activity)
    }
    

});