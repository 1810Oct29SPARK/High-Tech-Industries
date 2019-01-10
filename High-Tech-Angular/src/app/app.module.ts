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


const appRoutes: Routes = [
  {path: '', 
  redirectTo: 'news',
  pathMatch: 'full'},
  {path: 'news',
  component: NewsComponent},
  {path: 'profile',
  component: ProfileComponent,
  children: [
    {path: '**',
    redirectTo: '',
    pathMatch: 'full'}
  ]},
  {path: 'store',
  component: StoreComponent,
  children: [
    {path: '**',
    redirectTo: '',
    pathMatch: 'full'}
  ]},
  {path: 'employee',
  component: EmployeeComponent,
  children: [
    {path: 'member',
    component: MemberComponent},
    {path: '**',
    redirectTo: '',
    pathMatch: 'full'}
  ]},
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
    ProfileComponent,
    ProfileInfoComponent,
    StoreComponent,
    EmployeeComponent,
    MemberComponent,
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
