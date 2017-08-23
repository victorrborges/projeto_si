const app = angular.module("vs", ["ngRoute", "ngMessages","ngAnimate", "toastr"]);

app.run(['$rootScope',
  function ($rootScope) {

   $rootScope.permissaoAdmin = false;

   $rootScope.doLogout = function () {
            $rootScope.permissaoAdmin = false;
     }

}]);
