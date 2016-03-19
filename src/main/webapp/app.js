var app = angular.module("dashBoardApp", ['ui.bootstrap']);


app.controller("MainCtrl", function($scope, $http, $location, $anchorScroll) {

    $scope.loading = false;
    $scope.noProfileNoise = true;

    $scope.scrollTo = function(scrollLoc) {
       $location.hash(scrollLoc);
       $anchorScroll.yOffset =20; 
       $anchorScroll();
    }

    $scope.showforecast = true;
    var options = { types: ['(cities)']};
    var input = document.getElementById('cityName');
    var autocomplete = new google.maps.places.Autocomplete(input, options);
     google.maps.event.addListener(autocomplete, 'place_changed', function(){
     $scope.cityName = autocomplete.getPlace().address_components[0].long_name + "," + autocomplete.getPlace().address_components[1].long_name + "," + autocomplete.getPlace().address_components[2].long_name;
     })

    $scope.getCityInfo = function() {
         $scope.loading = true;
         $scope.showforecast = true;
         $scope.forecastitems = null;
         $http.get('/loadInfo?cityName=' + $scope.cityName + "&tempunits=" + $scope.tempunits).success(function(data) {
             $scope.info = data;
             $scope.currentWeather = data.appWeatherResponse;
         }).finally(function() {
               $scope.loading = false;
          });
     }


     $scope.getForecast = function() {
         $scope.loading = true;
         $scope.showforecast = false;
         $http.get('/forecastinfo?location=' + $scope.cityName + "&tempunits=" + $scope.tempunits).success(function(data) {
             $location.hash('forecast');
             $anchorScroll.yOffset =20; 
             $anchorScroll();
             $scope.forecastitems = data.forecastInfo;
         }).finally(function() {
             $scope.loading = false;
         });
     }


     $scope.existingUser = function() {
         $scope.exist_user = !$scope.exist_user;
         $scope.new_user = false;
         $scope.noProfileNoise = false;
     }

     $scope.newUser = function() {
        $scope.new_user = !$scope.new_user;
        $scope.exist_user = false;
        $scope.noProfileNoise = false;
     }

     $scope.notInterested = function() {
         $scope.exist_user = false;
         $scope.new_user = false;
         $scope.usr_loaded = false;
         $scope.noProfileNoise = true;
     }

     $scope.getUserInfo = function() {
         $scope.loading = true;
         $http.get('/getUserInfo?emailId=' + $scope.existingEmailId).success(function(data) {
             $scope.emailId = data.email;
             $scope.userlocation = data.location;
             $scope.emailPref = data.emailPref;
             $scope.usr_loaded = true;
             $scope.exist_user = false;
         }).finally(function() {
             $scope.loading = false;
         });
     }

     $scope.createUser = function() {
         $scope.loading = true;
         $http.get('/createUser?emailId=' + $scope.emailId + "&location=" + $scope.userlocation + "&emailPref=" + $scope.emailPref).success(function(data) {
             if (data != null) {
               $scope.new_user = false;
               $scope.success_alert=true;
             }
         }).finally(function() {
             $scope.loading = false;
             $scope.noProfileNoise = false;
         });
     }


     $scope.updateUser = function() {
         $scope.loading = true;
         $http.get('/updateUser?emailId=' + $scope.emailId + "&location=" + $scope.userlocation + "&emailPref=" + $scope.emailPref).success(function(data) {
             if (data != null) {
                 $scope.usr_loaded = false;
                 $scope.success_alert = true;
               }
         }).finally(function() {
             $scope.loading = false;
             $scope.noProfileNoise = false;
         });
     }

});