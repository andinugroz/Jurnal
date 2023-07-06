$(document).ready(function () {
    $('#table-jurnal').DataTable({
        ajax: {
            url: 'api/jurnal',
            dataSrc: ''
        },
        columns: [{
                data: null,
                render: (data, type, row, meta) => {
                    return meta.row + 1
                }
            },
            {
                data: 'judul'
            },
            {
                data: 'tanggal'
            },
            {
                data: 'jurusan'
            },
            {
                data: 'prodi'
            },
            {
                data: 'penulis'
            },
            {
                data: 'universitas'
            },
            {
                data: 'status'
            },
            {
                data: null,
                render: (data, type, row, meta) => {
                    return `
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailJurnal" onclick="findById(${data.id})">
                        Detail
                        </button>
                        
                        <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateJurnal" onclick="updateById(${data.id})">
                        Edit
                        </button>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"  onclick="deleteJurnal(${data.id})">
                        Delete
                        </button>
                    `
                }
            }
        ]
    });
});

$('#create-jurnal').click((e) => {
    e.preventDefault()

    let abstrak = $("#jurnalAbstrak").val()
    let filejurnal = $("#jurnalFilejurnal").val()
    let judul = $("#jurnalJudul").val()
    let jurusan = $("#jurnalJurusan").val()
    let penulis = $("#jurnalPenulis").val()
    let prodi = $("#jurnalProdi").val()
    let tanggal = $("#jurnalTanggal").val()
    let universitas = $("#jurnalUniversitas").val()
    let status = $("#jurnalStatus").val()

    if (judul === "" || judul === null) {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Please fill all field',
            showConfirmButton: false,
            timer: 1000
        })}
    if (jurusan === "" || jurusan === null) {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Please fill all field',
            showConfirmButton: false,
            timer: 1000
        })}
    if (penulis === "" || penulis === null) {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Please fill all field',
            showConfirmButton: false,
            timer: 1000
        })}
    if (prodi === "" || prodi === null) {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Please fill all field',
            showConfirmButton: false,
            timer: 1000
        })}
    if (tanggal === "" || tanggal === null) {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Please fill all field',
            showConfirmButton: false,
            timer: 1000
        })}
    if (universitas === "" || universitas === null) {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Please fill all field',
            showConfirmButton: false,
            timer: 1000
        })
    } else {
        $.ajax({
            method: "POST",
            url: "api/jurnal",
            dataType: "JSON",
            contentType: "application/json",
            data: JSON.stringify({
                abstrak: abstrak,
                filejurnal: filejurnal,
                judul: judul,
                jurusan: jurusan,
                penulis: penulis,
                prodi: prodi,
                tanggal: tanggal,
                universitas: universitas,
                status:status
            }),
            success: (result) => {
                $('#createJurnal').modal('hide')
                $('#table-jurnal').DataTable().ajax.reload()
                $("#jurnalAbstrak").val()
                $("#jurnalFilejurnal").val()
                $("#jurnalJudul").val()
                $("#jurnalJurusan").val()
                $("#jurnalPenulis").val()
                $("#jurnalTanggal").val()
                $("#jurnalUniversitas").val()
                $("#jurnalStatus").val()
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Jurnal has been Add',
                    showConfirmButton: false,
                    timer: 2000
                })
            }
        })
    }
})

function updateById(id) {
    $.ajax({
        method: "GET",
        url: "api/jurnal/" + id,
        dataType: "json",
        success: (result) => {
            $("#update-id").val(`${result.id}`)
            $("#update-abstrak").val(`${result.abstrak}`)
            $("#update-filejurnal").val(`${result.filejurnal}`)
            $("#update-judul").val(`${result.judul}`)
            $("#update-jurusan").val(`${result.jurusan}`)
            $("#update-penulis").val(`${result.penulis}`)
            $("#update-prodi").val(`${result.prodi}`)
            $("#update-status").val(`${result.status}`)
            $("#update-tanggal").val(`${result.tanggal}`)
            $("#update-universitas").val(`${result.universitas}`)
            $("#update-employee_id").val(`${result.employee_id}`)
        }
    })
}

$('#update-jurnal').click((e) => {
    e.preventDefault()

    let abstrak = $("#update-abstrak").val()
    let filejurnal = $("#update-filejurnal").val()
    let judul = $("#update-judul").val()
    let jurusan = $("#update-jurusan").val()
    let penulis = $("#update-penulis").val()
    let prodi = $("#update-prodi").val()
    let status = $("#update-status").val()
    let tanggal = $("#update-tanggal").val()
    let universitas = $("#update-universitas").val()
    let employee_id = $("#update-employee_id").val()
    
    if (abstrak === "" || abstrak === null) {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: 'Please fill all field',
            showConfirmButton: false,
            timer: 1000
        })
    } else {
        $.ajax({
            method: "PUT",
            url: "api/jurnal/"+ $("#update-id").val(),
            dataType: "JSON",
            contentType: "application/json",
            data: JSON.stringify({
                abstrak: abstrak,
                filejurnal: filejurnal,
                judul: judul,
                jurusan: jurusan,
                penulis: penulis,
                prodi: prodi,
                status:status,
                tanggal: tanggal,
                universitas: universitas,
                employee_id: employee_id
            }),
            success: (result) => {
                $('#createJurnal').modal('hide')
                $('#table-jurnal').DataTable().ajax.reload()
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Jurnal has been Update',
                    showConfirmButton: false,
                    timer: 2000
                })
            }
        })
    }
})

function deleteJurnal(id) {
    
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        method: "DELETE",
                        url: "api/jurnal/" + id,
                        dataType: "json",
                        success: (result) => {
                            $('#table-jurnal').DataTable().ajax.reload()
                Swal.fire(
                    'Deleted!',
                    'Region has been deleted.',
                    'success'
                )
                }
            })
        }
    })
}

function findById(id) {
    $.ajax({
        method: "GET",
        url: "api/jurnal/" + id,
        dataType: "json",
        success: (result) => {
            $("#detail-id").text(`${result.id}`)
            $("#detail-judul").text(`${result.judul}`)
            $("#detail-penulis").text(`${result.penulis}`)
            $("#detail-tanggal").text(`${result.tanggal}`)
            $("#detail-abstrak").text(`${result.abstrak}`)
            $("#detail-jurusan").text(`${result.jurusan}`)
            $("#detail-prodi").text(`${result.prodi}`)
            $("#detail-universitas").text(`${result.universitas}`)
            $("#detail-status").text(`${result.status}`)
        }
    })
}