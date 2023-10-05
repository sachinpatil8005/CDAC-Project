using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class Subscribtion
{
    public int IdSubscribtion { get; set; }

    public int Amount { get; set; }

    public int Validity { get; set; }

    public int Props { get; set; }
}
