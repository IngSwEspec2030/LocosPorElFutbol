import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './components/pages/dashboard/dashboard.component';
import { AppTodoComponent } from './components/pages/app-todo/app-todo.component';
import { MyProfileComponent } from './components/pages/my-profile/my-profile.component';
import { InvoiceComponent } from './components/pages/invoice/invoice.component';
import { MyListingComponent } from './components/pages/my-listing/my-listing.component';
import {AddActivityComponent} from './components/pages/activity/add-activity.component';
import {ListActivityComponent} from './components/pages/activity-list/list-activity.component';

const routes: Routes = [
    {path: '', component: DashboardComponent},
    {path: 'dashboard', component: DashboardComponent},
    {path: 'my-listing', component: MyListingComponent},
    {path: 'activity', component: AddActivityComponent},
    {path: 'activity-edit/:id', component: AddActivityComponent},
    {path: 'activity-list', component: ListActivityComponent},
    {path: 'app-todo', component: AppTodoComponent},
    {path: 'my-profile', component: MyProfileComponent},
    {path: 'invoice', component: InvoiceComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
