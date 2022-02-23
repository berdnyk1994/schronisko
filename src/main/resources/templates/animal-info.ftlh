
<!DOCTYPE html>
<html>
<head>
    <title>Shelter</title>
</head>
<body>
<h1>Shelter</h1><hr>
<h4>Detail animal information</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<h3>${animal.type}</h3>
<b>Dog name: </b>${animal.name}<br>
<b>Dog size: </b>${animal.size}<br>
<b>Dog age: </b>${animal.age}<br>
<b>Dog sex: </b>${animal.sex}<br>
<b>Dog number: </b>${animal.number}<br>
<b>Date of admission: </b>${animal.dateOfAdmission}<br>
<b>Dog CHIP number: </b>${animal.chipNumber}<br>
<b>Dog status: </b>${animal.status}<br>
<b>Dog description: </b>${animal.description}<br>
<hr>


<form action="/animal/delete/${animal.id}" method="post">
    <input type="submit" value="Delete animal"/>
</form>
</body>
</html>