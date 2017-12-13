app.controller('myDayCtrl', function($scope, $http, $location) {
    var defaultFirstDay = '2017-12-1';
    var events = [];
    $http.get("/event").then(function (response) {
        response.data.forEach(function (event) {
            event.times.forEach(function (time) {
                //var startSeparator = 'T' + (Math.min.apply(null, time.hours) < 10 ? 0 : '');
                //var endSeparator = 'T' + (Math.max.apply(null, time.hours) < 10 ? 0 : '');
                var day = time.day + 1;
                //var start = defaultFirstDay + day + startSeparator + Math.min.apply(null, time.hours) + ':00:00';
                //var end = defaultFirstDay + day + endSeparator + Math.max.apply(null, time.hours) + ':00:00';
                time.hours.forEach(function (hour) {
                    var startSeparator = 'T' + (hour < 10 ? 0 : '');
                    var endSeparator = 'T' + (hour + 1 < 10 ? 0 : '');
                    events.push({
                        title: event.name,
                        start: defaultFirstDay + day + startSeparator + hour + ':00:00',
                        end: defaultFirstDay + day + endSeparator + (hour + 1) + ':00:00'
                    });
                })

            });
        });
        $('#calendar').fullCalendar({
            header: {
                left: '',
                center: '',
                right: ''
            },
            allDaySlot: false,
            defaultDate: defaultFirstDay + '1',
            firstDay: 1,
            columnFormat: 'dddd',
            timeFormat: 'H:mm',
            slotLabelFormat: 'H:mm',
            defaultView: 'agendaWeek',
            events: events

        })
    });
})
