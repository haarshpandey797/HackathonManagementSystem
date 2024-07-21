<style>
    @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap");
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,400;0,700;1,400;1,700&display=swap');

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: "Poppins", sans-serif;
    }

    .container-card {
        margin-top: 100px;
        width: 100%;
        align-items: center;
        display: flex;
        justify-content: center;
        background-color: #fcfcfc;
    }

    .card {
        border-radius: 10px;
        box-shadow: 0 5px 10px 0 rgba(0, 0, 0, 0.3);
        width: 600px;
        height: 260px;
        background-color: #ffffff;
        padding: 10px 30px 40px;
    }

    .card h3 {
        font-size: 22px;
        font-weight: 600;
    }

    .drop_box {
        margin: 10px 0;
        padding: 30px;
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: column;
        border: 3px dotted #a3a3a3;
        border-radius: 5px;
    }

    .drop_box h4 {
        font-size: 16px;
        font-weight: 400;
        color: #2e2e2e;
    }

    .drop_box p {
        margin-top: 10px;
        margin-bottom: 20px;
        font-size: 12px;
        color: #a3a3a3;
    }

    .btn-card {
        text-decoration: none;
        background-color: #005af0;
        color: #ffffff;
        padding: 10px 20px;
        border: none;
        outline: none;
        transition: 0.3s;
    }

    .btn-card:hover {
        text-decoration: none;
        background-color: #ffffff;
        color: #005af0;
        padding: 10px 20px;
        border: none;
        outline: 1px solid #010101;
    }

    .form input {
        margin: 10px 0;
        width: 100%;
        background-color: #e2e2e2;
        border: none;
        outline: none;
        padding: 12px 20px;
        border-radius: 4px;
    }

    /* file upload button */
    input[type="file"]::file-selector-button {
        border-radius: 4px;
        padding: 0 16px;
        height: 40px;
        cursor: pointer;
        background-color: white;
        border: 1px solid rgba(0, 0, 0, 0.16);
        box-shadow: 0px 1px 0px rgba(0, 0, 0, 0.05);
        margin-right: 16px;
        transition: background-color 200ms;
    }

    /* file upload button hover state */
    input[type="file"]::file-selector-button:hover {
        background-color: #f3f4f6;
    }

    /* file upload button active state */
    input[type="file"]::file-selector-button:active {
        background-color: #e5e7eb;
    }
</style>

<div class="container-card">
    <div class="card">
        <h3>${uploadHeading}</h3>
        <div class="drop_box">
            <header>
                <h4>Select File here</h4>
            </header>
            <p>Files Supported: PDF, TEXT, DOC , DOCX</p>
            <form action="handleBulkUploadProblems" method="post" enctype="multipart/form-data">
                <div style="display:flex; align-items:center;">
                    <input type="file" name="file" accept=".xlsx" required />
                    <button type="submit" class="btn btn-card" id="uploadButton">Upload</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    document.querySelector('input[type="file"]').addEventListener('click', function(event) {
        event.stopPropagation();
    });

    document.querySelector('#uploadButton').addEventListener('click', function(event) {
        // No need to handle file input click here
    });
</script>
