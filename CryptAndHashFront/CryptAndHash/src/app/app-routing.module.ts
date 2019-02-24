import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CryptageComponent } from './cryptage/cryptage.component';
import { HashageComponent } from './hashage/hashage.component';
import { AWSComponent } from './aws/aws.component';
import { AboutComponent } from './about/about.component';
import { AccueilComponent } from './accueil/accueil.component';

const routes: Routes = [
  {path: 'accueil', component: AccueilComponent},
  {path: 'hashage', component: HashageComponent},
  {path: 'cryptage', component: CryptageComponent},
  {path: 'aws', component: AWSComponent},
  {path: 'about', component: AboutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
