function filterForm(){
let content=`<table style="width: 100%; border: 1px solid; margin: 20px">
    <tr>
        <td>Filter</td>
        <td colspan="4"></td>
    </tr>
    <tr>
        <td colspan="2" style="width: 30%">Price gape</td>
        <td style="width: 30%">Category</td>
        <td style="width: 30%">Gender</td>
        <td rowspan="2"><button onclick="search()">search</button> </td>
     </tr>
      <tr>
        <td colspan="2"><input id="lowPrice" type="text"> <label> >>> </label> <input id="highPrice" type="text"></td>
        <td><select  id="category"></select></td> 
        <td><select  id="category">
                <option value=""></option>
                <option value="Nam">Nam</option>
                <option value="Nữ">Nữ</option>
        </select></td>
        
       
     </tr>
</table>`
    document.getElementById("filter").innerHTML=content;
}

function filter(){
    filterForm();
}