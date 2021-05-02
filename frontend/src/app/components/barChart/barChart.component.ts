import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {User} from 'src/app/models/User/user.model';

const BASE_URL = '/api/materials/';

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


export class BarChartComponent implements OnInit {
  usersData: User[] = [];
  studentsData: string[] = [];
  numberMaterialsData: number[] = [];

  constructor(
    private router: Router, activatedRoute: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit() {
    this.getStudentsInCourseList();
  }

  public getStudentsInCourseList() {
    this.http.get<any>(BASE_URL + 'graph').subscribe(
      response => {
        let data: any = response;
        for (var i = 0; i < data.length; i++) {
          let newUserList = data[i];
          this.usersData.push(newUserList);

        }
        for (var i = 0; i < this.usersData.length; i++) {
          this.numberMaterialsData.push(this.usersData[i].numberMaterial);
          this.studentsData.push(this.usersData[i].name);
        }
      }
    );
  }

  public chartType: string = 'bar';

  public chartDatasets: Array<any> = [
    {data: this.numberMaterialsData, label: 'Nº de materiales resueltos'}
  ];

  public chartLabels: Array<any> = this.studentsData;

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
