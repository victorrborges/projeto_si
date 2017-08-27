app.config(function ($routeProvider) {
    $routeProvider.when("/",{
        templateUrl: "view/include/search.html"
    }).when("/complaint/register/food", {
        templateUrl: "view/include/registerComplaintFood.html",
        controller : "registerComplaintCtrl",
    }).when("/complaint/register/animal",{
      templateUrl: "view/include/registerComplaintAnimal.html",
      controller : "registerComplaintCtrl",
    }).when("/search_complaint", {
        templateUrl : "view/include/search_complaint.html",
        controller: "searchComplaintCtrl"
    }).when("/search_health_unit", {
        templateUrl: "view/include/search_health_unit.html",
        controller : "searchHealthUnitCtrl",
    }).when("/search_health_unit_specialty", {
          templateUrl: "view/include/search_health_unit_specialty.html",
          controller : "searchHealthUnitSpecialtyCtrl",
    }).when("/search_average",{
        templateUrl : "view/include/search_average_per_patient.html",
        controller: "searchAverangeCtrl"
    }).when("/createdcomplaint/:id", {
        templateUrl : "view/include/successPage.html",
        controller : "messageCreatedComplaintCtrl"
    }).when("/generalSituationComplaints", {
        templateUrl : "view/include/generalSituationComplaints.html",
        controller : "generalSituationComplaintsCtrl"
    }).when("/login", {
        templateUrl : "view/include/login.html",
        controller : "loginCtrl"
    }).when("/change_complaint_status", {
        templateUrl : "view/include/change_complaint_status.html",
        controller : "changeComplaintStatusCtrl"
    }).when("/change_townhall_status", {
        templateUrl : "view/include/change_townhall_status.html",
        controller : "changeTownhallStatusCtrl"
    }).when("/register_health_unit", {
          templateUrl : "view/include/registerHealthUnit.html",
          controller : "registerHealthUnitCtrl"
    }).otherwise({
        redirectTo: '/'
    });
});
