/**
 * Created by user on 24/02/2016.
 */
var myapp = angular.module( 'homeModule', ['googleOauth'] );

myapp.config( function (TokenProvider) {
    // Demo configuration for the "angular-oauth demo" project on Google.
    // Log in at will!

    // Sorry about this way of getting a relative URL, powers that be.

    var baseUrl = document.URL.replace( '/home.html', '' );
    TokenProvider.extendConfig( {
        clientId: '202317690708-062ts2disvkoi7lfm6strp08updu3n45.apps.googleusercontent.com',
        redirectUri: baseUrl + '/home.html',  // allow lunching demo from a mirror
        scopes: ["https://www.googleapis.com/auth/userinfo.email"]
    } );
} );
myapp.controller( 'homeController', function ($scope, $http,$rootScope,$log, $window, Token) {
    $scope.accessToken = Token.get()

    $scope.recipelist = new Array();

    $scope.findRecipe = function () {

        $http.get( 'https://api.edamam.com/api/nutrition-data?app_id=b80b3342&app_key=84d36ea17c2bdb172a2c3027a0b5705b&ingr='+ $scope.recipe +'' ).success( function (data1) {
            console.log( data1 );
                $scope.recipelist[0]= {

                    "calories": data1.calories,
                    "weight": data1.totalWeight
                };


        } )

    };

    //Watson Text-to-Speech api

/*    $scope.getWatson = function () {
        $http.put( 'https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?username=7fe01a17-d7c8-4358-964d-7b13d57a5001&password= jLDbPj5bTqKg &text='+ $scope.recipe+'' ).success( function (data1) {
            console.log( data1 );
        } )
    };*/
    $scope.getWatson = function () {
        $http.put( 'https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?username=b234d9a3-d86a-4476-9c56-07173e317489&password=0pmyS3pDPqUv&text='+ $scope.recipe+'' ).success( function (data1) {
            console.log( data1 );
        } )
    };





    $rootScope.updateSession = function () {
        //reads the session variables if exist from php
        $rootScope.session = "hello";

    };

    $rootScope.updateSession();



} );


