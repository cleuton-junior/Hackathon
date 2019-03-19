import angular from 'angular';
import uirouter from 'angular-ui-router';

import MulherController from './mulher.controller';

import mulherService from '../../servicos/mulher.service';

export default angular.module('myApp.mulher', [uirouter, mulherService])
  .controller('MulherController', MulherController)
  .name;

  