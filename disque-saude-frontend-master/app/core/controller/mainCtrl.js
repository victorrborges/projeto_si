app.controller("searchAverangeCtrl", function ($scope, $http) {

    $scope.average = null;

    $scope.searchAveragePerPatient = function (id) {
        $http.get("http://localhost:5000/SpringBootRestApi/api/geral/medicos/" + id).then(function successCallback(response) {
            $scope.average = response.data.obj;
        }, function errorCallback(error) {
            console.log("Unidade Não Encontrada");
        });
    }
});



app.controller("registerComplaintCtrl", function ($scope, $http, toastr, $location) {

    $scope.registerComplaint = function (complaint) {
      complaint.type = "queixa";
      complaint.situacao = "aberta";
	     console.log(complaint);
        $http.post("http://localhost:5000/SpringBootRestApi/api/queixa/", JSON.stringify(complaint))
            .then(function success(response) {
                toastr.success("Queixa adicionada com sucesso!");
                $location.path('/createdcomplaint/' + response.data.id);
            }, function error(error) {
                console.log(error);
                console.log("Problemas ao tentar adicionar queixa.");
            });
    }
    $scope.registerComplaintAnimal = function (complaint) {
        complaint.type = "queixa_animal";
        complaint.situacao = "aberta";
           console.log(complaint);
          $http.post("http://localhost:5000/SpringBootRestApi/api/queixa/", JSON.stringify(complaint))
              .then(function success(response) {
                  toastr.success("Queixa adicionada com sucesso!");
                  $location.path('/createdcomplaint/' + response.data.id);
              }, function error(error) {
                  console.log(error);
                  console.log("Problemas ao tentar adicionar queixa.");
              });
      }
});

app.controller("searchAverangeCtrl", function ($scope, $http) {

    $scope.average = null;

    $scope.searchAveragePerPatient = function (id) {
        $http.get("http://localhost:5000/SpringBootRestApi/api/geral/medicos/" + id).then(function successCallback(response) {
            $scope.average = response.data.obj;
        }, function errorCallback(error) {
            console.log("Unidade Não Encontrada");
        });
    }
});

app.controller("searchComplaintCtrl", function ($scope, $http) {
    $scope.complaint;

    $scope.searchComplaint = function (id) {
        $http.get("http://localhost:5000/SpringBootRestApi/api/queixa/" + id).then(function successCallback(response) {
            $scope.complaint = response.data;
            console.log($scope.complaint);
        }, function errorCallback(error) {
            $scope.complaint = null;
            console.log(error);
        });
    }
});

app.controller("searchHealthUnitCtrl", function ($scope, $http) {

    $scope.units = [];

    $scope.searchHU = function (neighborhood) {
      console.log(neighborhood);
        $http.get("http://localhost:5000/SpringBootRestApi/api/unidade/busca/bairro/" + neighborhood)
            .then(function success(response) {
                $scope.units = [];
                for (i = 0; i < response.data.length; i++) {
                  unit = response.data[i]
                  if(unit.especialidades != null) {
                    unit.type = "Hospital"
                  } else {
                    unit.type = "Posto de Saúde"
                  }
                  $scope.units.push(unit);
                }
                console.log("Foram encontradas Unidades de saúde");
                console.log(response.data);
            }, function failed(error) {
                console.log("Erro na busca de unidades");
                console.log(error.data.errorMessage);
            });
    }
});

app.controller("searchHealthUnitSpecialtyCtrl", function ($scope, $http) {

    $scope.units = [];

    $scope.searchHU = function (especialidade) {
      console.log(especialidade);
        $http.get("http://localhost:5000/SpringBootRestApi/api/unidade/busca/especialidade/" + especialidade)
            .then(function success(response) {
                $scope.units = [];
                for (i = 0; i < response.data.length; i++) {
                  unit = response.data[i]
                  if(unit.especialidades != null) {
                    unit.type = "Hospital"
                  } else {
                    unit.type = "Posto de Saúde"
                  }
                  $scope.units.push(unit);
                }
                console.log("Foram encontradas Unidades de saúde");
                console.log(response.data);
            }, function failed(error) {
                console.log("Erro na busca de unidades");
                console.log(error.data.errorMessage);
            });
    }
});


app.controller("generalSituationComplaintsCtrl", function ($scope, $http) {

    $scope.situation = "";

    var getGeneralSituationComplaints = function (neighborhood) {

        $http.get("http://localhost:5000/SpringBootRestApi/api/geral/situacao")
            .then(function success(response) {
                console.log(response.data.obj);

                if(response.data.obj == 0){
                    $scope.situation = {
                        status: "RUIM",
                        color: "label-danger"
                    };

                } else if(response.data.obj == 1){

                    $scope.situation = {
                        status: "REGULAR",
                        color: "label-primary"
                    };
                } else {
                    $scope.situation = "";
                    $scope.situation = {
                        status: "BOM",
                        color: "label-success"
                    };

                }
            }, function failed(error) {
                console.log("Erro na busca de unidades");
                console.log(error.data.errorMessage);
            });
    }

    getGeneralSituationComplaints();
});

app.controller("messageCreatedComplaintCtrl", function ($scope, $routeParams) {
    $scope.responseComplaintId = "";
    var showMessage = function () {
        $scope.responseComplaintId = $routeParams.id;
    }

    showMessage();
});

app.controller("loginCtrl", function ($scope, $http, toastr, $rootScope, $location) {


  $scope.doLogin = function (admin) {
    console.log(JSON.stringify(admin));
    $http.post("http://localhost:5000/SpringBootRestApi/api/admin/login/", JSON.stringify(admin))
        .then(function success(response) {
          $location.path('/');
          toastr.success("Admin logado com sucesso!");
          $rootScope.permissaoAdmin = true;
         }, function error(error) {
           console.log(error);
           console.log("Nao foi possivel se autenticar.");
       });
    }


});

app.controller("changeComplaintStatusCtrl", function ($scope, $http, toastr) {
    $scope.complaint;

    $scope.searchComplaint = function (id) {
        $http.get("http://localhost:5000/SpringBootRestApi/api/queixa/" + id).then(function successCallback(response) {
            $scope.complaint = response.data;
            console.log($scope.complaint);
        }, function errorCallback(error) {
            $scope.complaint = null;
            console.log(error);
        });
    }


    $scope.updateComplaint = function (complaint) {
        $http.put("http://localhost:5000/SpringBootRestApi/api/queixa/" + complaint.id, JSON.stringify(complaint)).then(function successCallback(response) {
          toastr.success("Queixa atualizada com sucesso!");
        }, function errorCallback(error) {
            $scope.complaint = null;
            console.log(error);
        });
    }
});

app.controller("changeTownhallStatusCtrl", function ($scope, $http, toastr) {
  $scope.setTownhallStatus = function (status) {
    console.log(status);
    $http.post("http://localhost:5000/SpringBootRestApi/api/prefeitura/" + status).then(function successCallback(response) {
      toastr.success("Situação da prefeitura atualizada com sucesso!");
    }, function errorCallback(error) {
        console.log(error);
    });
  }

});

app.controller("registerHealthUnitCtrl", function ($scope, $http, toastr) {

  // Especialidades
  $scope.especialidades = ['Clinica Geral', 'Pediatria', 'Obstetricia', 'Endocrinologia', 'Cardiologia'];

  $scope.selection = [];

  // Toggle selection for a given fruit by name
  $scope.toggleSelection = function toggleSelection(especialidade) {
    var idx = $scope.selection.indexOf(especialidade);

    // Is currently selected
    if (idx > -1) {
      $scope.selection.splice(idx, 1);
    }

    // Is newly selected
    else {
      $scope.selection.push(especialidade);
    }
  };

  $scope.registerUnit = function (unit) {
    if(unit.type == 'hospital') {
      unit.especialidades = $scope.selection;
    }

    console.log(unit);

    $http.post("http://localhost:5000/SpringBootRestApi/api/unidade/", JSON.stringify(unit)).then(function successCallback(response) {
      toastr.success("Unidade de saude adicionada com sucesso!");
    }, function errorCallback(error) {
        console.log(error);
    });


  }





});
