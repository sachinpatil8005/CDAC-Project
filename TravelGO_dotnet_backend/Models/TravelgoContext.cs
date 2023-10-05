using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace TravelGO_dotnet_backend.Models;

public partial class TravelgoContext : DbContext
{
    public TravelgoContext()
    {
    }

    public TravelgoContext(DbContextOptions<TravelgoContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Admin> Admins { get; set; }

    public virtual DbSet<Ammenity> Ammenities { get; set; }

    public virtual DbSet<Booking> Bookings { get; set; }

    public virtual DbSet<BookingPayment> BookingPayments { get; set; }

    public virtual DbSet<Host> Hosts { get; set; }

    public virtual DbSet<Login> Logins { get; set; }

    public virtual DbSet<Property> Properties { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<SubPayment> SubPayments { get; set; }

    public virtual DbSet<Subscribtion> Subscribtions { get; set; }

    public virtual DbSet<Traveller> Travellers { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySql("server=localhost;port=3306;user=root;password=root;database=travelgo", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.0.31-mysql"));

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder
            .UseCollation("utf8mb4_0900_ai_ci")
            .HasCharSet("utf8mb4");

        modelBuilder.Entity<Admin>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PRIMARY");

            entity.ToTable("admin");

            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.Contact).HasColumnName("contact");
            entity.Property(e => e.Emailid)
                .HasMaxLength(255)
                .HasColumnName("emailid");
            entity.Property(e => e.Fname)
                .HasMaxLength(45)
                .HasColumnName("fname");
            entity.Property(e => e.Lname)
                .HasMaxLength(45)
                .HasColumnName("lname");
            entity.Property(e => e.Password)
                .HasMaxLength(45)
                .HasColumnName("password");
            entity.Property(e => e.Username)
                .HasMaxLength(45)
                .HasColumnName("username");
        });

        modelBuilder.Entity<Ammenity>(entity =>
        {
            entity.HasKey(e => e.IdAmmenity).HasName("PRIMARY");

            entity.ToTable("ammenity");

            entity.Property(e => e.IdAmmenity).HasColumnName("id_ammenity");
            entity.Property(e => e.Bedrooms).HasColumnName("bedrooms");
            entity.Property(e => e.HasAc).HasColumnName("has_ac");
            entity.Property(e => e.HasCaretaker).HasColumnName("has_caretaker");
            entity.Property(e => e.HasKitchen).HasColumnName("has_kitchen");
            entity.Property(e => e.HasParking).HasColumnName("has_parking");
            entity.Property(e => e.HasTv).HasColumnName("has_tv");
            entity.Property(e => e.HomeType)
                .HasMaxLength(45)
                .HasColumnName("home_type");
            entity.Property(e => e.Rooms).HasColumnName("rooms");
            entity.Property(e => e.Summary)
                .HasMaxLength(45)
                .HasColumnName("summary");
        });

        modelBuilder.Entity<Booking>(entity =>
        {
            entity.HasKey(e => e.IdBooking).HasName("PRIMARY");

            entity.ToTable("booking");

            entity.HasIndex(e => e.PropId, "fk_booking_properties");

            entity.HasIndex(e => e.TravelId, "fk_booking_traveller");

            entity.Property(e => e.IdBooking).HasColumnName("id_booking");
            entity.Property(e => e.Checkin)
                .HasColumnType("datetime")
                .HasColumnName("checkin");
            entity.Property(e => e.Checkout)
                .HasColumnType("datetime")
                .HasColumnName("checkout");
            entity.Property(e => e.PropId).HasColumnName("prop_id");
            entity.Property(e => e.Totalfare).HasColumnName("totalfare");
            entity.Property(e => e.TravelId).HasColumnName("travel_id");

            entity.HasOne(d => d.Prop).WithMany(p => p.Bookings)
                .HasForeignKey(d => d.PropId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_booking_properties");

            entity.HasOne(d => d.Travel).WithMany(p => p.Bookings)
                .HasForeignKey(d => d.TravelId)
                .HasConstraintName("fk_booking_traveller");
        });

        modelBuilder.Entity<BookingPayment>(entity =>
        {
            entity.HasKey(e => e.IdBookPay).HasName("PRIMARY");

            entity.ToTable("booking_payment");

            entity.HasIndex(e => e.BookingId, "fk_book_idx");

            entity.Property(e => e.IdBookPay).HasColumnName("id_book_pay");
            entity.Property(e => e.Amount).HasColumnName("amount");
            entity.Property(e => e.BookingId).HasColumnName("booking_id");
            entity.Property(e => e.PayMode)
                .HasMaxLength(45)
                .HasColumnName("pay_mode");

            entity.HasOne(d => d.Booking).WithMany(p => p.BookingPayments)
                .HasForeignKey(d => d.BookingId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_book");
        });

        modelBuilder.Entity<Host>(entity =>
        {
            entity.HasKey(e => e.IdHost).HasName("PRIMARY");

            entity.ToTable("host");

            entity.HasIndex(e => e.IdLogin, "FKsnc3fc8swnshgshg1ss9gcoa4");

            entity.HasIndex(e => e.SubId, "fk_host_sub");

            entity.Property(e => e.IdHost).HasColumnName("id_host");
            entity.Property(e => e.Count).HasColumnName("count");
            entity.Property(e => e.Email)
                .HasMaxLength(45)
                .HasColumnName("email");
            entity.Property(e => e.Gender)
                .HasMaxLength(45)
                .HasColumnName("gender");
            entity.Property(e => e.IdLogin).HasColumnName("id_login");
            entity.Property(e => e.Name)
                .HasMaxLength(45)
                .HasColumnName("name");
            entity.Property(e => e.Password)
                .HasMaxLength(45)
                .HasColumnName("password");
            entity.Property(e => e.SubId).HasColumnName("sub_id");

            entity.HasOne(d => d.IdLoginNavigation).WithMany(p => p.Hosts)
                .HasForeignKey(d => d.IdLogin)
                .HasConstraintName("FKsnc3fc8swnshgshg1ss9gcoa4");
        });

        modelBuilder.Entity<Login>(entity =>
        {
            entity.HasKey(e => e.IdLogin).HasName("PRIMARY");

            entity.ToTable("login");

            entity.HasIndex(e => e.RoleId, "role_id_idx");

            entity.Property(e => e.IdLogin).HasColumnName("id_login");
            entity.Property(e => e.Name)
                .HasMaxLength(45)
                .HasColumnName("name");
            entity.Property(e => e.Password)
                .HasMaxLength(45)
                .HasColumnName("password");
            entity.Property(e => e.RoleId).HasColumnName("role_id");
            entity.Property(e => e.Status).HasColumnName("status");
        });

        modelBuilder.Entity<Property>(entity =>
        {
            entity.HasKey(e => e.IdProperty).HasName("PRIMARY");

            entity.ToTable("properties");

            entity.HasIndex(e => e.Address, "Address_UNIQUE").IsUnique();

            entity.HasIndex(e => e.IdHost, "FK56454euym114ait6e2qr64rdl");

            entity.HasIndex(e => e.IdAmmenity, "fk_amm_idx");

            entity.Property(e => e.IdProperty).HasColumnName("id_property");
            entity.Property(e => e.Address)
                .HasMaxLength(45)
                .HasColumnName("address");
            entity.Property(e => e.City)
                .HasMaxLength(45)
                .HasColumnName("city");
            entity.Property(e => e.IdAmmenity).HasColumnName("id_ammenity");
            entity.Property(e => e.IdHost).HasColumnName("id_host");
            entity.Property(e => e.Pictures).HasColumnName("pictures");
            entity.Property(e => e.Price).HasColumnName("price");
            entity.Property(e => e.State)
                .HasMaxLength(45)
                .HasColumnName("state");

            entity.HasOne(d => d.IdAmmenityNavigation).WithMany(p => p.Properties)
                .HasForeignKey(d => d.IdAmmenity)
                .HasConstraintName("fk_amm");

            entity.HasOne(d => d.IdHostNavigation).WithMany(p => p.Properties)
                .HasForeignKey(d => d.IdHost)
                .HasConstraintName("FK56454euym114ait6e2qr64rdl");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.IdRole).HasName("PRIMARY");

            entity.ToTable("role");

            entity.Property(e => e.IdRole)
                .ValueGeneratedNever()
                .HasColumnName("id_role");
            entity.Property(e => e.Type)
                .HasMaxLength(45)
                .HasColumnName("type");
        });

        modelBuilder.Entity<SubPayment>(entity =>
        {
            entity.HasKey(e => e.IdSubPayment).HasName("PRIMARY");

            entity.ToTable("sub_payment");

            entity.HasIndex(e => e.IdHost, "fk_host_idx");

            entity.Property(e => e.IdSubPayment).HasColumnName("id_sub_payment");
            entity.Property(e => e.Amount).HasColumnName("amount");
            entity.Property(e => e.IdHost).HasColumnName("id_host");
            entity.Property(e => e.PayMode)
                .HasMaxLength(45)
                .HasColumnName("pay_mode");

            entity.HasOne(d => d.IdHostNavigation).WithMany(p => p.SubPayments)
                .HasForeignKey(d => d.IdHost)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_host");
        });

        modelBuilder.Entity<Subscribtion>(entity =>
        {
            entity.HasKey(e => e.IdSubscribtion).HasName("PRIMARY");

            entity.ToTable("subscribtion");

            entity.Property(e => e.IdSubscribtion).HasColumnName("id_subscribtion");
            entity.Property(e => e.Amount).HasColumnName("amount");
            entity.Property(e => e.Props).HasColumnName("props");
            entity.Property(e => e.Validity).HasColumnName("validity");
        });

        modelBuilder.Entity<Traveller>(entity =>
        {
            entity.HasKey(e => e.IdTraveller).HasName("PRIMARY");

            entity.ToTable("traveller");

            entity.HasIndex(e => e.Email, "Email_UNIQUE").IsUnique();

            entity.HasIndex(e => e.IdLogin, "FK8jct2hakt7m62qx95exyehc3s");

            entity.HasIndex(e => e.Password, "Pass_UNIQUE").IsUnique();

            entity.HasIndex(e => e.IdTraveller, "id_traveller_UNIQUE").IsUnique();

            entity.Property(e => e.IdTraveller).HasColumnName("id_traveller");
            entity.Property(e => e.Email)
                .HasMaxLength(45)
                .HasColumnName("email");
            entity.Property(e => e.Gender)
                .HasMaxLength(45)
                .HasColumnName("gender");
            entity.Property(e => e.IdLogin).HasColumnName("id_login");
            entity.Property(e => e.Name)
                .HasMaxLength(45)
                .HasColumnName("name");
            entity.Property(e => e.Password)
                .HasMaxLength(45)
                .HasColumnName("password");

            entity.HasOne(d => d.IdLoginNavigation).WithMany(p => p.Travellers)
                .HasForeignKey(d => d.IdLogin)
                .HasConstraintName("FK8jct2hakt7m62qx95exyehc3s");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
