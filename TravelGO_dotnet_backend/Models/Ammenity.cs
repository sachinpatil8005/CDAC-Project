using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class Ammenity
{
    public int IdAmmenity { get; set; }

    public int? Rooms { get; set; }

    public string? HomeType { get; set; }

    public int? Bedrooms { get; set; }

    public sbyte? HasKitchen { get; set; }

    public sbyte? HasAc { get; set; }

    public sbyte? HasParking { get; set; }

    public sbyte? HasTv { get; set; }

    public sbyte? HasCaretaker { get; set; }

    public string? Summary { get; set; }

    public virtual ICollection<Property> Properties { get; set; } = new List<Property>();
}
