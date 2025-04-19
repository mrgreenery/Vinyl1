package model;

public interface VinylState
{
  void reserveVinyl(Vinyl vinyl);
  void borrowVinyl(Vinyl vinyl);
  void returnVinyl(Vinyl vinyl);
  void removeVinyl(Vinyl vinyl);
}
