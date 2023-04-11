import java.util.Scanner;

public class PlaylistStack {
    private static final int MAX_SIZE = 100; // batas maksimal jumlah lagu dalam playlist
    private String[] playlist; // array untuk menyimpan playlist
    private int top; // indeks lagu teratas dalam playlist

    public PlaylistStack() {
        playlist = new String[MAX_SIZE];
        top = -1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Playlist kosong");
        } else {
            System.out.println("Playlist:");
            for (int i = top; i >= 0; i--) {
                System.out.println((top - i + 1) + ". " + playlist[i]);
            }
        }
    }

    public void push(String lagu) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Playlist penuh");
        } else {
            top++;
            playlist[top] = lagu;
            System.out.println(lagu + " ditambahkan ke playlist");
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Playlist kosong");
        } else {
            String lagu = playlist[top];
            top--;
            System.out.println(lagu + " dihapus dari playlist");
        }
    }

    public void insert(String lagu, int posisi) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Playlist penuh");
        } else if (posisi < 1 || posisi > top + 2) {
            System.out.println("Posisi yang dimasukkan tidak valid");
        } else {
            for (int i = top; i >= posisi; i--) {
                playlist[i + 1] = playlist[i];
            }
            top++;
            playlist[posisi - 1] = lagu;
            System.out.println(lagu + " ditambahkan ke playlist pada posisi " + posisi);
        }
    }

    public void remove(int posisi) {
        if (top == -1) {
            System.out.println("Playlist kosong");
        } else if (posisi < 1 || posisi > top + 1) {
            System.out.println("Posisi yang dimasukkan tidak valid");
        } else {
            String lagu = playlist[posisi - 1];
            for (int i = posisi; i <= top; i++) {
                playlist[i - 1] = playlist[i];
            }
            top--;
            System.out.println(lagu + " dihapus dari playlist pada posisi " + posisi);
        }
    }

    public void removeAll() {
        if (top == -1) {
            System.out.println("Playlist kosong");
        } else {
            top = -1;
            System.out.println("Semua lagu dihapus dari playlist");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlaylistStack playlistStack = new PlaylistStack();
        int menu;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Tampilkan Data Playlist");
            System.out.println("2. Tambah Data Playlist");
            System.out.println("3. Hapus Data Playlist");
            System.out.println("4. Tambah Data Playlist di Urutan Tertentu");
            System.out.println("5. Hapus Data Playlist di Urutan Tertentu");
            System.out.println("6. Hapus Semua Playlist");
           
