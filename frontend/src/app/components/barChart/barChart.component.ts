import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
//import { ChartOptions, ChartType } from 'chart.js';

@Component({
  selector: 'app-barChart',
  template:`
  <!--START GRAPH-->
                            <div class="row">
                                <div class="col-xl-12 col-lg-12">
                                    <div class="card shadow mb-4">
                                        <div
                                                class="card-header2 py-3 d-flex flex-row align-items-center justify-content-between">
                                            <h6 class="m-0 font-weight-bold" style="color: black;">AVANCE DEL CURSO</h6>
                                        </div>
                                        <div class="card-body">
                                            <div class="chart-area">
                                                <canvas id="myChart" width="400" height="400"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--END GRAPH-->
<!--
<div class="d-none">
        {{#students_in_course}}
        <div id="{{id}}" class="user">
            <span class="name">{{name}}</span>
            <span class="numberMaterial">{{numberMaterial}}</span>
        </div>
        {{/students_in_course}}
    </div>
-->
`


  ,
  styleUrls: ['../../../assets/css/style.css']
})

export class BarChartComponent implements OnInit {



  constructor(private router: Router, activatedRoute: ActivatedRoute) {
    const id = activatedRoute.snapshot.params['id'];


  }


  ngOnInit(): void {

  }

}
/*
<script>
        const users = [];

        $(".user").each(function() {
            const parent = $(this);
            const userId = parent.attr('id');

            const name = $("#" + userId + " > .name").text();
            const numberMaterial = $("#" + userId + " > .numberMaterial").text();

            const user = {
                name: name,
                numberMaterial: numberMaterial
            };

            users.push(user);

        });

        const names = users.map(user => user.name);
        const numberMaterials=users.map((user => user.numberMaterial));

        //variables o const o let nunca var
        var ctx = document.getElementById('myChart').getContext('2d');
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: names,

                datasets: [{
                    label: '# of Votes',
                    data: numberMaterials,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(16, 134, 28, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(16,134,28, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true,
                            precision:0
                        }
                    }]
                }
            }
        });
    </script>
 */
