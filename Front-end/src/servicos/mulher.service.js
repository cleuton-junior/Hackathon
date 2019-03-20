import angular from 'angular';

class MulherService {

    constructor($http) {
        this.$http = $http;
        //const apiBase = "http://localhost:9090/projeto/api";
        const apiBase = "http://localhost:8080";
        this.path =  apiBase + "/mulher";
        this.sap = apiBase + "/sapato";
    }
    
    getDonos() {
        return this.$http.get(this.path);
    }
    getSapatos() {
        return this.$http.get(this.sap);
    }  
    remover(id) {
        return this.$http.delete(this.path + "/"+ id);
    }
    salvar(data) {
        return this.$http.post(this.path,data);
    }
    editar(id){
        return this.$http.get(this.path + "/"+ id);
       
    }
    atualizar(data){
        return this.$http.put(this.path + '/id',data);
    }
    salvarSapato(data) {
        return this.$http.post(this.sap,data);
    }
    removerSapato(id) {
        return this.$http.delete(this.sap + "/"+ id);
    }
    }
    

export default angular.module('services.mulher-service', [])
.service('mulherService', MulherService)
.name;