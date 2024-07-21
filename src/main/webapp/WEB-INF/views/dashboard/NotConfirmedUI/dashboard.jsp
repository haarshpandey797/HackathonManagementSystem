<!DOCTYPE html>

<%@include file="navbar.jsp" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Table Example</title>
  <style>
    body {
      font-family: 'Helvetica Neue', Helvetica, Arial;
      font-size: 14px;
      line-height: 20px;
      font-weight: 400;
      color: #3b3b3b;
      -webkit-font-smoothing: antialiased;
      font-smoothing: antialiased;

    }

    @media screen and (max-width: 580px) {
      body {
        font-size: 16px;
        line-height: 22px;
      }

      .row {
        display: block;
        padding: 14px 0 7px;
      }

      .row.header {
        padding: 0;
        height: 6px;
      }

      .row.header .cell {
        display: none;
      }

      .cell:before {
        content: attr(data-title);
        min-width: 98px;
        font-size: 10px;
        line-height: 10px;
        font-weight: bold;
        text-transform: uppercase;
        color: #969696;
        display: block;
        margin-bottom: 3px;
      }

      .cell {
        margin-bottom: 10px;
      }
    }

    .wrapper {
      margin: 0 auto;
      padding: 40px;
      max-width: 800px;
    }

    .table {
      margin: 0 0 40px 0;
      width: 100%;
      box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
      display: table;
    }

    @media screen and (max-width: 580px) {
      .table {
        display: block;
      }
    }

    .row {
      display: table-row;
      background: #f6f6f6;
    }

    .row:nth-of-type(odd) {
      background: #e9e9e9;
    }

    .row.header {
      font-weight: 900;
      color: #ffffff;
      background: #ea6153;
    }

    .row.green {
      background: #27ae60;
    }

    .row.blue {
      background: #2980b9;
    }

    .cell {
      padding: 6px 12px;
      display: table-cell;
    }

    @media screen and (max-width: 580px) {
      .cell {
        padding: 2px 16px;
        display: block;
      }
    }
  </style>
</head>
<body>

<div class="wrapper">

    <h1 >Hackathons</h1>

    <br>
    <div class="table">

        <div class="row header green">
          <div class="cell">Name</div>
          <div class="cell">No of. Team</div>
          <div class="cell">Winner</div>
          <div class="cell">Start Date</div>
          <div class="cell">Status</div>
        </div>
    
        <div class="row">
          <div class="cell" data-title="Product">Hack It</div>
          <div class="cell" data-title="Unit Price">8</div>
          <div class="cell" data-title="Quantity">Zero Degree</div>
          <div class="cell" data-title="Date Sold">03/15/2014</div>
          <div class="cell" data-title="Status">Yet to Start</div>
        </div>
    
        <div class="row">
          <div class="cell" data-title="Product">Hacker Earth</div>
          <div class="cell" data-title="Unit Price">45</div>
          <div class="cell" data-title="Quantity">Abc Coders</div>
          <div class="cell" data-title="Date Sold">02/28/2014</div>
          <div class="cell" data-title="Status">In Transit</div>
        </div>
    
        <div class="row">
          <div class="cell" data-title="Product">Nucleus Problem Solver</div>
          <div class="cell" data-title="Unit Price">10</div>
          <div class="cell" data-title="Quantity">Null Pointers</div>
          <div class="cell" data-title="Date Sold">02/10/2014</div>
          <div class="cell" data-title="Status">Done</div>
        </div>
    
        <div class="row">
          <div class="cell" data-title="Product">Nucleus Inter-Hack </div>
          <div class="cell" data-title="Unit Price">6</div>
          <div class="cell" data-title="Quantity">One of One</div>
          <div class="cell" data-title="Date Sold">01/14/2014</div>
          <div class="cell" data-title="Status">Done</div>
        </div>
    
      </div>

  </div>

</div>

</body>
</html>
