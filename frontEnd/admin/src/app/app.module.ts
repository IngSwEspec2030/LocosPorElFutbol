import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FooterComponent} from './components/layouts/footer/footer.component';
import {HeaderComponent} from './components/layouts/header/header.component';
import {SidebarComponent} from './components/layouts/sidebar/sidebar.component';
import {DashboardComponent} from './components/pages/dashboard/dashboard.component';
import {AppTodoComponent} from './components/pages/app-todo/app-todo.component';
import {MyProfileComponent} from './components/pages/my-profile/my-profile.component';
import {InvoiceComponent} from './components/pages/invoice/invoice.component';
import {MyListingComponent} from './components/pages/my-listing/my-listing.component';
import {WebAnalyticsComponent} from './components/charts/web-analytics/web-analytics.component';
import {AddActivityComponent} from './components/pages/activity/add-activity.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { ListActivityComponent } from './components/pages/activity-list/list-activity.component';
import { UserComponent } from './components/pages/user/user.component';
import { UserListComponent } from './components/pages/user-list/user-list.component';

@NgModule({
    declarations: [
        AppComponent,
        FooterComponent,
        HeaderComponent,
        SidebarComponent,
        DashboardComponent,
        AppTodoComponent,
        MyProfileComponent,
        InvoiceComponent,
        MyListingComponent,
        WebAnalyticsComponent,
        AddActivityComponent,
        ListActivityComponent,
        UserComponent,
        UserListComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        BrowserModule,
        ReactiveFormsModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
