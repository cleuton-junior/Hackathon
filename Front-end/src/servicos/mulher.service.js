import angular from 'angular';

class MulherService {

    constructor($http) {
        this.$http = $http;
        //const apiBase = "http://localhost:9090/projeto/api";
        const apiBase = "http://localhost:8080";
        this.path =  apiBase + "/mulher";
    }
    
    getDonos() {
        return this.$http.get(this.path);
    }
        
    remover(id) {
        return this.$http.delete(this.path + "/id");
    }
    salvar(data) {
        return this.$http.post(this.path,data);
    }
    editar(id){
        return this.$http.get(this.path + '/id');
    }
    atualizar(data){
        return this.$http.put(this.path + '/id',data);
    }
    }
    

export default angular.module('services.mulher-service', [])
.service('mulherService', MulherService)
.name;