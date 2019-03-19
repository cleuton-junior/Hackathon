import { inherit } from "@uirouter/core";



export default class MulherController {

  constructor(mulherService,$stateParams,$state) {
    var vm = this;
    this.name = 'Mulher';
    if($state.params){
      this.mulher = $state.params.obj
    }else{
      this.mulheres=[];
    }
    
    this.sapato={};
    this.mulher={};

    init();
    
    function init(){
      mulherService.getDonos().then(function abc(resp) {
        vm.mulheres = resp.data; 
      });  
    }
    this.salvar = function(){
      mulherService.salvar(vm.mulher).then(function save(resp){
        vm.mulher = resp.data;
      });
    }
    this.excluir = function(){
      mulherService.remover(vm.mulher).then(function exc(resq){
          vm.mulher = resq.data;
        })
      }
    this.editar = function(obj){
        alert(obj.id)
        $state.go('cadastrar',{obj: obj})
        console.log("Enviou" + vm.mulher.nome);
        
              }
    }
    }

MulherController.$inject = ['mulherService','$stateParams','$state'];
