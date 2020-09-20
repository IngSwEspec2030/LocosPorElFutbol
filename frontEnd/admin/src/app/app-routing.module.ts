import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './components/pages/dashboard/dashboard.component';
import { AppTodoComponent } from './components/pages/app-todo/app-todo.component';
import { MyProfileComponent } from './components/pages/my-profile/my-profile.component';
import { InvoiceComponent } from './components/pages/invoice/invoice.component';
import { MyListingComponent } from './components/pages/my-listing/my-listing.component';
import { AddListingComponent } from './components/pages/add-listing/add-listing.component';
import {AddActivityComponent} from './components/pages/add-activity/add-activity.component';
import {ListActivityComponent} from './components/pages/list-activity/list-activity.component';

const routes: Routes = [
    {path: '', component: DashboardComponent},
    {path: 'dashboard', component: DashboardComponent},
    {path: 'app-todo', component: AppTodoComponent},
    {path: 'my-profile', component: MyProfileComponent},
    {path: 'invoice', component: InvoiceComponent},
    {path: 'my-listing', component: MyListingComponent},
    {path: 'add-activity', component: AddActivityComponent},
    {path: 'edit-activity/:id', component: AddActivityComponent},
    {path: 'list-activity', component: ListActivityComponent},
    {path: 'add-listing', component: AddListingComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
