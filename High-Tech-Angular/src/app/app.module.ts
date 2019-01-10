import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { NewsComponent } from './news/news.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfileInfoComponent } from './profile-info/profile-info.component';
import { StoreComponent } from './store/store.component';
import { EmployeeComponent } from './employee/employee.component';
import { MemberComponent } from './member/member.component';
import { CanActivate, CanActivateChild } from '@angular/router';


// class profileGuard implements CanActivate{
//   canActivate(){
//     return true;
//   }
// }

// class profileChildGuard implements CanActivateChild{
//   canActivateChild(){
//     return true;
//   }
// }

//routing paths that determine what components will be shown at a given URL
const appRoutes: Routes = [
  //default URL will redirect to the news page
  {path: '', 
  redirectTo: 'high-tech/news',
  pathMatch: 'full'},
  {path: 'high-tech/news',
  component: NewsComponent},
  {path: 'high-tech/profile',
  component: ProfileComponent,
  //all paths have a child path that will redirect them back to the specific path (if someone is at /news and types /news/fewaoiniugn)
  children: [
    {path: '**',
    redirectTo: '',
    pathMatch: 'full'}
  ]},
  {path: 'high-tech/store',
  component: StoreComponent,
  children: [
    {path: '**',
    redirectTo: '',
    pathMatch: 'full'}
  ]},
  {path: 'high-tech/employee',
  component: EmployeeComponent,
  children: [
    {path: 'member',
    component: MemberComponent},
    {path: '**',
    redirectTo: '',
    pathMatch: 'full'}
  ]},
  //if the URL is wrong, it will redirect back to news. 
  { path: '**',
  redirectTo: 'high-tech/news',
  pathMatch: 'full'
  }
];



@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    NewsComponent,
    ProfileComponent,
    ProfileInfoComponent,
    StoreComponent,
    EmployeeComponent,
    MemberComponent,
  ],
  imports: [
    BrowserModule, 
    //needed for using routes 
    RouterModule.forRoot(
      appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
