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
    this.sapatos=[];

    init();
    sapat();
    
    function init(){
      mulherService.getDonos().then(function abc(resp) {
        vm.mulheres = resp.data; 
      });  
    }
    function  sapat(){
      mulherService.getSapatos().then(function sap(resp) {
        vm.sapatos = resp.data; 
      });
    }
    this.salvar = function(){
      mulherService.salvar(vm.mulher).then(function save(resp){
        vm.mulher = resp.data;
        init();
      },
      
      function(err){
        alert("Esse nome já está cadastrado");
        init();
      }
        
      );
    }
    this.excluir = function(id){
      mulherService.remover(id).then(function exc(resq){
        init();
        })
      }
    this.editar = function(obj){
     
      mulherService.editar(obj).then(function edi(resq){
        
            vm.mulher = resq.data;
            vm.mulheres=[];
            vm.sapatos={};
                
             init();
      })
                      
              }
      this.salvarSapato = function(){
        mulherService.salvarSapato(vm.sapato).then(function save(resp){
        vm.sapato= resp.data;
          sapat();
        });
      }
      this.excluirSapato = function(id){
        mulherService.removerSapato(id).then(function exc(resq){
          sapat();
          })
        }
    }
    }

MulherController.$inject = ['mulherService','$stateParams','$state'];
