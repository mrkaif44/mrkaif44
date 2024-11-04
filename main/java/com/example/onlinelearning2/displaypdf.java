package com.example.onlinelearning2;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class displaypdf extends AppCompatActivity {
    private WebView webView;
    private Button downloadButton;
   ImageView btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_displaypdf);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        webView = findViewById(R.id.webView);
        downloadButton = findViewById(R.id.downloadButton);

        // Retrieve PDF URL from Intent and check for null/empty
        String pdfUrl = getIntent().getStringExtra("pdf_url");
        if (pdfUrl == null || pdfUrl.isEmpty()) {
            Toast.makeText(this, "Invalid PDF link provided.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Load PDF using Google Drive viewer
        loadPdfInWebView(pdfUrl);

        // Set up button click listener
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadPDF(pdfUrl);
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void loadPdfInWebView(String pdfUrl) {
        String googleDriveViewerUrl = pdfUrl; // Make sure this URL is suitable for viewing
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(googleDriveViewerUrl);
    }

    private void downloadPDF(String pdfUrl) {
        // Replace with the direct download URL if needed
        String downloadUrl = "https://drive.google.com/uc?id=" + Uri.parse(pdfUrl).getLastPathSegment();

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
        request.setTitle("Downloading PDF");
        request.setDescription("Please wait...");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "downloaded_file.pdf");

        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        if (downloadManager != null) {
            downloadManager.enqueue(request);
            Toast.makeText(this, "Download started.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Download manager not available.", Toast.LENGTH_SHORT).show();
        }
    }
}