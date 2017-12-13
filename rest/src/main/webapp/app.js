var app = angular.module('Horarium', ['ngRoute']).config(function ($sceProvider) {
    $sceProvider.enabled(false);    
}).config(function ($routeProvider) {
    $routeProvider
        .when('/activity', {
            templateUrl: 'activities.html',
            controller: 'activityCtrl'
        })
        .when('/activity/add', {
            templateUrl: 'add.html',
            controller: 'addActivityCtrl'
        })
        .when('/register', {
            templateUrl: 'register.html',
            controller: 'registerCtrl'
        })
        .when('/error', {
            templateUrl: 'myerror.html'
        })
        .when('/myday', {
            templateUrl: 'myday.html',
            controller: 'myDayCtrl'
        })
        .otherwise({
            templateUrl : 'login.html',
            controller: 'loginCtrl'
        });
});