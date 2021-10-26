import { TecnicoReadComponent } from './view/components/tecnico/tecnico-read/tecnico-read.component';
import { HomeComponent } from './view/components/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  
  { path: '',
    component: HomeComponent
  },
  { path: 'tecnicos',
    component: TecnicoReadComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
