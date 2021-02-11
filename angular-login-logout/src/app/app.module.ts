import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';

import { FormsModule } from '@angular/forms';
import { LogoutComponent } from './logout/logout.component';
import { HttpInterceptorService } from './httpInterceptor.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AccordionModule } from 'primeng/accordion';   
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';  
import {PanelModule} from 'primeng/panel';
import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import {DynamicDialogModule} from 'primeng/dynamicdialog';
import { AddProductComponent } from './add-product/add-product.component';
import {ColorPickerModule} from 'primeng/colorpicker';

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    MenuComponent,
    LoginComponent,
    LogoutComponent,
    DashboardComponent,
    AddProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    AccordionModule,
    PanelModule,
    TableModule,
    ButtonModule,
    DynamicDialogModule,
    ColorPickerModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
