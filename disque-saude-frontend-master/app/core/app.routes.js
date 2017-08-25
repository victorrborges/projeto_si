app.config(function ($routeProvider) {
    $routeProvider.when("/",{
        templateUrl: "view/include/search.html"
    }).when("/complaint/register", {
        templateUrl: "view/include/registerComplaint.html",
        controller : "registerComplaintCtrl",
    }).when("/search_complaint", {
        templateUrl : "view/include/search_complaint.html",
        controller: "searchComplaintCtrl"
    }).when("/search_health_unit", {
        templateUrl: "view/include/search_health_unit.html",
        controller : "searchHealthUnitCtrl",
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
    }).otherwise({
        redirectTo: '/'
    });
});
