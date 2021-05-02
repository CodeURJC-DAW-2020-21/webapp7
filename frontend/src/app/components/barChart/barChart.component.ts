import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {BarChartService} from 'src/app/services/barChart/barChart.service';
import {HttpClient} from '@angular/common/http';
import { User } from 'src/app/models/User/user.model';

@Component({
  selector: 'app-bar-chart',
  template: `
  <!--START GRAPH-->
  <div class="row">
      <div class="col-xl-12 col-lg-12">
          <div class="card shadow mb-4">
              <div
                      class="card-header2 py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold" style="color: black;">AVANCE DEL CURSO</h6>
              </div>
              <div class="card-body">
                 <div style="display: block">
                      <canvas baseChart
                        [datasets]="chartDatasets"
                        [labels]="chartLabels"
                        [options]="chartOptions"
                        [colors]="chartColors"
                        [chartType]="chartType">
                      </canvas>
                </div>
              </div>
          </div>
      </div>
  </div>
  <!--END GRAPH-->`,
  styleUrls: ['../../../assets/css/style.css']
})

export class BarChartComponent implements OnInit{
  student:User;
  students:User[];

  constructor(
    private router: Router, activatedRoute: ActivatedRoute, public barChartService: BarChartService,httpClient: HttpClient) {

    /*
    materialService.getRecomendations().subscribe(
      recomendations => this.recomendations = recomendations,
    error => console.error(error)
  );
    console.log('recomendaciones ' + this.recomendations);
  }
  */
     const id = activatedRoute.snapshot.params['id'];
     barChartService.getStudentsInCourseList().subscribe(
     users => this.students = users,
     error => console.error(error)
   );
     console.log('users ' + this.students);
     console.log(this.students)
   }

   ngOnInit():void{}

  /*printChartStuff(event: any) {
    event.preventDefault();
    let list = this.barChartService.users;
    console.log(list);
    /*
    for (let i = 0; i < list.length; i++) {
      console.log(list[i]);
      if (list[i].category === id){
        this.courseService.deleteCourse(this.courseService.courses[i].id);
    }


  }
  */


  public chartType: string = 'bar';

  public chartDatasets: Array<any> = [
    {data: [65, 59, 80, 81, 56, 55, 40], label: 'Nº de materiales resueltos'}
  ];

  public chartLabels: Array<any> = ['student1', 'student2', 'student3', 'student4', 'student5', 'student6'];

  public chartColors: Array<any> = [
    {
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 2,
    }
  ];

  public chartOptions: any = {
    responsive: true
  };

  public chartClicked(e: any): void {
  }

  public chartHovered(e: any): void {
  }
}
