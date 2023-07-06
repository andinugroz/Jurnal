$(document).ready(function () {
    $('#table-jurnalapprove').DataTable({
        ajax: {
            url: 'api/jurnal/approve',
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
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailRegion" onclick="findById(${data.id})">
                        Detail
                        </button>
                        <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateRegion" onclick="updateById(${data.id})">
                        Edit
                        </button>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"  onclick="deleteRegion(${data.id})">
                        Delete
                        </button>
                    `
                }
            }
        ]
    });
});