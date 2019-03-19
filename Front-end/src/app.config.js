routing.$inject = ['$stateProvider', '$urlRouterProvider'];

export default function routing($stateProvider, $urlRouterProvider) {
    let homeState = {
        name: 'home',
        url: '/home',
        templateUrl: './modulos/home/home.view.html',
        controller: 'HomeController',
        controllerAs: 'vm'
      }
      $stateProvider.state(homeState);
      
      let mulherState = {
        name: 'mulher',
        url: '/mulher',
        templateUrl: './modulos/mulher/mulher.view.html',
        controller: 'MulherController',
        controllerAs: 'vm'
      }
      $stateProvider.state(mulherState);

      let cadastrarState = {
        name: 'cadastrar',
        url: '/cadastrar',
        templateUrl: './modulos/mulher/cadastrar.view.html',
        controller: 'MulherController',
        controllerAs: 'vm'
       
        
      }
      $stateProvider.state(cadastrarState);
      
      $urlRouterProvider.otherwise('/home')  
}