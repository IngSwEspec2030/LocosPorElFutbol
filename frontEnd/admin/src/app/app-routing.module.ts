import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './components/pages/dashboard/dashboard.component';
import { AppTodoComponent } from './components/pages/app-todo/app-todo.component';
import { MyProfileComponent } from './components/pages/my-profile/my-profile.component';
import { InvoiceComponent } from './components/pages/invoice/invoice.component';
import { MyListingComponent } from './components/pages/my-listing/my-listing.component';
import { AddListingComponent } from './components/pages/add-listing/add-listing.component';

const routes: Routes = [
    {path: '', component: DashboardComponent},
    {path: 'dashboard', component: DashboardComponent},
    {path: 'app-todo', component: AppTodoComponent},
    {path: 'my-profile', component: MyProfileComponent},
    {path: 'invoice', component: InvoiceComponent},
    {path: 'my-listing', component: MyListingComponent},
    {path: 'add-listing', component: AddListingComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
