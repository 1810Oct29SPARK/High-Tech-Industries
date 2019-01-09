import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { NewsComponent } from './news/news.component';
import { NewsPageComponent } from './news-page/news-page.component';
import { EmployeePageComponent} from './employee-page/employee-page.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { StorePageComponent } from './store-page/store-page.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfileInfoComponent } from './profile-info/profile-info.component';
import { ShowDirective } from './show.directive';
import { StoreComponent } from './store/store.component';
import { EmployeeComponent } from './employee/employee.component';


const appRoutes: Routes = [
  {path: '', 
  redirectTo: 'news',
  pathMatch: 'full'},
  {path: 'news',
  component: NewsPageComponent},
  {path: 'profile',
  component: ProfilePageComponent},
  {path: 'store',
  component: StorePageComponent},
  {path: 'employee',
  component: EmployeePageComponent},
  { path: '**',
  redirectTo: 'news',
  pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    NewsComponent,
    NewsPageComponent,
    EmployeePageComponent,
    ProfilePageComponent,
    StorePageComponent,
    ProfileComponent,
    ProfileInfoComponent,
    ShowDirective,
    StoreComponent,
    EmployeeComponent,
  ],
  imports: [
    BrowserModule, 
    RouterModule.forRoot(
      appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    ProfileInfoComponent,
    // ProfileItemsComponent
  ]
})
export class AppModule { }
