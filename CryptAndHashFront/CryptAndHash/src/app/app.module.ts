import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { CryptageComponent } from './cryptage/cryptage.component';
import { HashageComponent } from './hashage/hashage.component';
import { AWSComponent } from './aws/aws.component';
import { AboutComponent } from './about/about.component';
import { SearchResultComponent } from './search-result/search-result.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    CryptageComponent,
    HashageComponent,
    AWSComponent,
    AboutComponent,
    SearchResultComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
