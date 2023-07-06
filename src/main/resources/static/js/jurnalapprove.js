console.log("ok")
$(document).ready(function () {
    $('#table-jurnal-add').DataTable({
        ajax: {
            url: '/api/jurnal/status',
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
                data: null,
                render: (data, type, row, meta) => {
                    return `
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailJurnalStatus" onclick="findById(${data.id})">
                    Detail
                    </button>
                    `
                }
            }
        ]
    });
});

function findById(id) {
    $.ajax({
        method: "GET",
        url: "/api/jurnal/" + id,
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

